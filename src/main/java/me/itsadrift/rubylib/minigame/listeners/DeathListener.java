package me.itsadrift.rubylib.minigame.listeners;

import me.itsadrift.rubylib.RubyLib;
import me.itsadrift.rubylib.minigame.events.MinigameDeathEvent;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

// Figure out how to register this listener
public class DeathListener implements Listener {

    private RubyLib rubyLib;
    public DeathListener(RubyLib rubyLib) {
        this.rubyLib = rubyLib;
    }

    @EventHandler
    public void onAthenaDeath(MinigameDeathEvent event) {
        EntityDamageEvent.DamageCause cause = event.getPlayer().getPlayer().getLastDamageCause().getCause();
        if (event.isPvP()) {
            switch (cause) {
                case FALL:
                    handleGroundFall(event);
                    break;
                case PROJECTILE:
                    handleProjectile(event);
                    break;
                case VOID:
                    handleVoid(event);
                    break;
                default:
                    broadcast(event, event.getDeathEvent().getDeathMessage());
            }
        } else {
            broadcast(event, event.getDeathEvent().getDeathMessage());
        }
        event.getDeathEvent().setDeathMessage(null); //disable vanilla death broadcast
    }


    /**
     * Death messages for the player hitting the ground
     */
    private void handleGroundFall(MinigameDeathEvent event) {
        String p = event.getPlayer().getName();
        String k = event.getKiller().getName();
        EntityDamageEvent.DamageCause cause = event.getDamageEvent().getEntityEvent().getCause();
        if (cause.equals(EntityDamageEvent.DamageCause.PROJECTILE)) {
            int dist = Math.round(event.getDamageEvent().getDistance());
            broadcast(event, String.format("%s was shot off a high place by %s (%dm)", p, k, dist));
        }
        else {
            broadcast(event, String.format("%s was knocked off a high place by %s", p, k));
        }
    }


    /**
     * Death messages for the player being shot
     */
    private void handleProjectile(MinigameDeathEvent event) {
        String p = event.getPlayer().getName();
        String k = event.getKiller().getName();
        int dist = Math.round(event.getDamageEvent().getDistance());
        broadcast(event, String.format("%s was shot by %s (%dm)", p, k, dist));
    }


    /**
     * Death messages for the player falling into the void
     */
    private void handleVoid(MinigameDeathEvent event) {
        String p = event.getPlayer().getName();
        String k = event.getKiller().getName();
        EntityDamageEvent.DamageCause cause = event.getDamageEvent().getEntityEvent().getCause();
        if (cause.equals(EntityDamageEvent.DamageCause.PROJECTILE)) {
            int dist = Math.round(event.getDamageEvent().getDistance());
            broadcast(event, String.format("%s was shot into the void by %s (%dm)", p, k, dist));
        }
        else {
            broadcast(event, String.format("%s was knocked into the void by %s", p, k));
        }
    }


    /**
     * Broadcast custom death message after colorizing it
     * @param event the AthenaDeathEvent we caught
     * @param msg the message to broadcast
     */
    private void broadcast(MinigameDeathEvent event, String msg) {
        msg = ChatColor.stripColor(msg);
        msg = ChatColor.GRAY + msg;
        msg = msg.replace(event.getPlayer().getName(), event.getPlayerTeam().getColor() + event.getPlayer().getName() + ChatColor.GRAY);
        if (event.isPvP()) {
            msg = msg.replace(event.getKiller().getName(), event.getKillerTeam().getColor() + event.getKiller().getName() + ChatColor.GRAY);
        }
        event.getGame().broadcast(msg);
    }

}
