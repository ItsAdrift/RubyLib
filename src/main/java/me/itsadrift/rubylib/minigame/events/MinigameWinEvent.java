package me.itsadrift.rubylib.minigame.events;

import me.itsadrift.rubylib.game.Game;
import me.itsadrift.rubylib.game.GameState;
import me.itsadrift.rubylib.minigame.teams.Team;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MinigameWinEvent extends MinigameEvent {
    private static final HandlerList handlers = new HandlerList();

    private Game game;
    private Team team;

    public MinigameWinEvent(Game game, Team team) {
        this.game = game;
        this.team = team;
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

    public Team getTeam() {
        return team;
    }
}
