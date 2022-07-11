package impl;

import me.itsadrift.rubylib.game.Game;
import org.bukkit.event.Listener;

/**
 * Extends on the 'Game' class, handles actual gameplay, etc.
 * When creating a new match of LayersPVP, call GameManager.createGame(class extends Game)
 * to create a new instance of LayersPVP, as well as assign an arena
 */
public class LayersPVP extends Game implements Listener {

    public LayersPVP() {
        super("layerspvp");
    }


}
