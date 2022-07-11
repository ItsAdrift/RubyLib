package me.itsadrift.rubylib.minigame.events;

import me.itsadrift.rubylib.game.Game;
import me.itsadrift.rubylib.minigame.player.AlivePlayer;
import me.itsadrift.rubylib.minigame.teams.Team;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MinigameDeathEvent extends Event implements Cancellable {

    private Game game;
    private AlivePlayer victim;
    private AlivePlayer killer;
    private PlayerDeathEvent deathEvent;
    private PlayerDamagePlayerEvent damageEvent;
    private long time;

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;

    public MinigameDeathEvent(Game match, AlivePlayer victim, PlayerDeathEvent deathEvent) {
        this.game = match;
        this.victim = victim;
        this.deathEvent = deathEvent;
        this.time = System.currentTimeMillis();
        this.damageEvent = null;
        this.killer = null;
    }


    public MinigameDeathEvent(Game match, AlivePlayer victim, AlivePlayer killer, PlayerDamagePlayerEvent damageEvent, PlayerDeathEvent deathEvent) {
        this(match, victim, deathEvent);
        this.killer = killer;
        this.damageEvent = damageEvent;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        isCancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    /**
     * Get the match the player died in
     */
    public Game getGame() {
        return game;
    }


    /**
     * Get the player who died
     */
    public AlivePlayer getPlayer() {
        return victim;
    }


    /**
     * The player who killed the victim
     */
    public AlivePlayer getKiller() {
        return killer;
    }


    /**
     * Get the team the victim is a member of
     */
    public Team getPlayerTeam() {
        return victim.getTeam();
    }


    /**
     * Get the killer's team
     */
    public Team getKillerTeam() {
        return killer.getTeam();
    }


    /**
     * Get the time, in milliseconds, that the kill happened
     */
    public long getTime() {
        return time;
    }


    /**
     * Get whether this was a PvP death or not.
     * @return true if the victim was killed by a player
     */
    public boolean isPvP() {
        return getDamageEvent() != null;
    }


    /**
     * Return the list of items dropped on death.
     * The resulting List can be modified to alter the items dropped during the event.
     */
    public List<ItemStack> getDrops() {
        return deathEvent.getDrops();
    }


    /**
     * Get the amount of experience dropped
     */
    public int getDroppedExp() {
        return deathEvent.getDroppedExp();
    }


    /**
     * Set how much experience will be dropped
     */
    public void setDroppedExp(int exp) {
        deathEvent.setDroppedExp(exp);
    }


    /**
     * Get the PlayerDamagePlayerEvent if the victim was killed by a player.
     * The last event damage event tagged within 7.5 seconds will be associated with a death,
     * so damage leading to an environmental kill can be recorded.
     */
    public PlayerDamagePlayerEvent getDamageEvent() {
        return damageEvent;
    }


    /**
     * Get the original PlayerDeathEvent
     */
    public PlayerDeathEvent getDeathEvent() {
        return deathEvent;
    }

}
