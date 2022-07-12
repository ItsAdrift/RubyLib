package me.itsadrift.rubylib.minigame.events;

import me.itsadrift.rubylib.game.Game;
import org.bukkit.event.Event;

public abstract class MinigameEvent extends Event {

    public boolean appliesToGame(Game game) {
        return game.getUUID().equals(getGame().getUUID());
    }

    public abstract Game getGame();

}
