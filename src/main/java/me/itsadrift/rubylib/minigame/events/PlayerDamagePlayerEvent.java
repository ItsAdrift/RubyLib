package me.itsadrift.rubylib.minigame.events;

import me.itsadrift.rubylib.game.Game;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDamagePlayerEvent extends Event implements Cancellable {


    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;

    private Game game;
    private Player damager;
    private Player victim;
    private boolean ranged;
    private EntityDamageByEntityEvent entityEvent;
    private long time;
    private int distance;
    private ItemStack item;


    public PlayerDamagePlayerEvent(Game game, Player damager, Player victim, boolean ranged, EntityDamageByEntityEvent entityEvent) {
        this.damager = damager;
        this.victim = victim;
        this.ranged = ranged;
        this.entityEvent = entityEvent;
        this.time = System.currentTimeMillis();
        this.distance = (int) Math.round(victim.getLocation().distance(damager.getLocation()));
        this.item = damager.getInventory().getItemInMainHand();
    }


    public HandlerList getHandlers() {
        return handlers;
    }


    public static HandlerList getHandlerList() {
        return handlers;
    }


    public boolean isCancelled() {
        return cancelled;
    }


    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Game getGame() {
        return game;
    }

    /**
     * Is this player trying to attack a team member?
     */
    public boolean isFriendlyFire() {
        throw new NotImplementedException("PlayerDamagePlayerEvent#isFrendlyFire() Not implemented");
    }

    /**
     * Get the attacking player
     */
    public Player getDamager() {
        return damager;
    }


    /**
     * Get the player who was hit
     */
    public Player getVictim() {
        return victim;
    }


    /**
     * Get the original EntityDamageByEntityEvent, so you can inspect damage info
     */
    public EntityDamageByEntityEvent getEntityEvent() {
        return entityEvent;
    }


    /**
     * Get the time, in milliseconds, that the damage happened
     */
    public long getTime() {
        return time;
    }


    /**
     * Get the distance, in meters/blocks, between the damager and victim
     */
    public int getDistance() {
        return distance;
    }


    /**
     * Get the weapon used
     */
    public ItemStack getItem() {
        return item;
    }


    /**
     * Get whether this is a ranged or melee attack
     */
    public boolean isRanged() {
        return ranged;
    }


}
