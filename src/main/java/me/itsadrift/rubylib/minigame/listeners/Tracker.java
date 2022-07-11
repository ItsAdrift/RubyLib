package me.itsadrift.rubylib.minigame.listeners;

import me.itsadrift.rubylib.RubyLib;
import me.itsadrift.rubylib.game.Game;
import me.itsadrift.rubylib.minigame.events.MinigameDeathEvent;
import me.itsadrift.rubylib.minigame.events.PlayerDamagePlayerEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;
import java.util.UUID;

public class Tracker implements Listener {


    private RubyLib plugin;
    private HashMap<UUID, PlayerDamagePlayerEvent> lastDamage;


    public Tracker(RubyLib plugin) {
        this.plugin = plugin;
        this.lastDamage = new HashMap<UUID, PlayerDamagePlayerEvent>();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }


    /**
     * Fire PlayerDamagePlayerEvent when a player attacks another player
     * while in an ongoing match.
     * @see PlayerDamagePlayerEvent
     */
    @EventHandler(priority = EventPriority.LOW)
    public void triggerPlayerDamagePlayerEvent(EntityDamageByEntityEvent event) {

        Player victim = null;
        Player attacker = null;
        boolean ranged = false;

        // Melee
        if (event.getEntityType().equals(EntityType.PLAYER) && event.getDamager().getType().equals(EntityType.PLAYER)) {
            victim = (Player) event.getEntity();
            attacker = (Player) event.getDamager();
        }

        // Projectile
        if (event.getEntityType().equals(EntityType.PLAYER) && event.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)) {
            Projectile a = (Projectile) event.getDamager();
            if (a.getShooter() instanceof Player) {
                victim = (Player) event.getEntity();
                attacker = (Player) a.getShooter();
                ranged = true;
            }
        }

        // Potion
        if (event.getEntityType().equals(EntityType.PLAYER) && event.getCause().equals(EntityDamageEvent.DamageCause.MAGIC)) {
            ThrownPotion potion = (ThrownPotion) event.getDamager();
            if (potion.getShooter() instanceof Player) {
                victim = (Player) event.getEntity();
                attacker = (Player) potion.getShooter();
                ranged = true;
            }
        }

        if (attacker == null || victim == null) return;
        Game game = plugin.getGameManager().getGameByPlayer(victim.getUniqueId());
        if (game == null) return;

        PlayerDamagePlayerEvent e = new PlayerDamagePlayerEvent(game, attacker, victim, ranged, event);
        Bukkit.getPluginManager().callEvent(e);
        if (e.isCancelled()) {
            event.setCancelled(true);
        } else {
            lastDamage.put(victim.getUniqueId(), e);
        }

    }


    /**
     * Fire AthenaDeathEvent when a player dies during a match.
     * @see MinigameDeathEvent
     */
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerDeath(PlayerDeathEvent event) {

        Player player = event.getEntity();
        Game game = plugin.getGameManager().getGameByPlayer(player.getUniqueId());
        if (game == null) return;
        MinigameDeathEvent e;

        PlayerDamagePlayerEvent damage = lastDamage.get(player.getUniqueId());
        boolean wasPlayer = damage != null && System.currentTimeMillis() - damage.getTime() <= 7500;
        if (wasPlayer) {
            e = new MinigameDeathEvent(game, game.getPlayer(damage.getVictim()), game.getPlayer(damage.getDamager()), damage, event);
        } else {
            e = new MinigameDeathEvent(game, game.getPlayer(player), event);
        }

        Bukkit.getPluginManager().callEvent(e);

    }
}
