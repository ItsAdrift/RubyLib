package me.itsadrift.rubylib.minigame.events;

import me.itsadrift.rubylib.game.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MinigameLeaveEvent extends MinigamePlayersChangedEvent {

    private static final HandlerList handlers = new HandlerList();

    private Game game;
    private Player player;

    public MinigameLeaveEvent(Game game, Player player) {
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

    @Override
    public Game getGame() {
        return game;
    }

    public Player getPlayer() {
        return player;
    }
}
