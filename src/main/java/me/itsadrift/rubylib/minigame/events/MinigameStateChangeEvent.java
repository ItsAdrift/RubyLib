package me.itsadrift.rubylib.minigame.events;

import me.itsadrift.rubylib.game.Game;
import me.itsadrift.rubylib.game.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class MinigameStateChangeEvent extends MinigameEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;

    private Game game;
    private GameState oldGameState;
    private GameState newGameState;

    public MinigameStateChangeEvent(Game game, GameState oldGameState, GameState newGameState) {
        this.game = game;
        this.oldGameState = oldGameState;
        this.newGameState = newGameState;
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

    @Override
    public Game getGame() {
        return game;
    }

    public GameState getOldGameState() {
        return oldGameState;
    }

    public GameState getNewGameState() {
        return newGameState;
    }

    public void setNewGameState(GameState newGameState) {
        this.newGameState = newGameState;
    }
}
