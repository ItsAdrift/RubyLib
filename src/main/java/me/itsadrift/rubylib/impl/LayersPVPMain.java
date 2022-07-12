package me.itsadrift.rubylib.impl;

import me.itsadrift.rubylib.RubyLib;
import me.itsadrift.rubylib.game.GameSettings;
import org.bukkit.plugin.java.JavaPlugin;

public class LayersPVPMain {

    private RubyLib rubyLib;
    private GameSettings gameSettings;

    public void onEnable() {
        rubyLib = RubyLib.getInstance();

        gameSettings = new GameSettings(GameSettings.ArenaType.SINGLE, GameSettings.ArenaLoad.NONE);
    }

    public void startNewGame() {
        rubyLib.getGameManager().createGame(new LayersPVP(gameSettings));
    }

}
