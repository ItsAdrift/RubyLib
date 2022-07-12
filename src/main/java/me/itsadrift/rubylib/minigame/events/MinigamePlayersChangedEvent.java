package me.itsadrift.rubylib.minigame.events;

import me.itsadrift.rubylib.game.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class MinigamePlayersChangedEvent extends MinigameEvent {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;

    private Game game;

    public MinigamePlayersChangedEvent(Game game) {
        this.game = game;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public Game getGame() {
        return game;
    }
}
