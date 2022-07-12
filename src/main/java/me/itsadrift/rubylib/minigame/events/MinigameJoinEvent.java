package me.itsadrift.rubylib.minigame.events;

import me.itsadrift.rubylib.game.Game;
import me.itsadrift.rubylib.game.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MinigameJoinEvent extends MinigamePlayersChangedEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;

    private Game game;
    private Player player;

    public MinigameJoinEvent(Game game, Player player) {
        super(game);
        this.game = game;
        this.player = player;
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

    public Player getPlayer() {
        return player;
    }
}
