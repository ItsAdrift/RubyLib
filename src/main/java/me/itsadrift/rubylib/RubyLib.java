package me.itsadrift.rubylib;

import me.itsadrift.rubylib.game.GameManager;
import me.itsadrift.rubylib.minigame.listeners.DeathListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import impl.LayersPVP;

public final class RubyLib extends JavaPlugin {

    private LayersPVP skyWars;

    private GameManager gameManager;
    private static RubyLib instance; // Testing purposes

    @Override
    public void onEnable() {
        skyWars = new LayersPVP();

        instance = this;
        // Plugin startup logic
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new DeathListener(this), this);

        gameManager = new GameManager();
    }

    @Override
    public  void onDisable() {
        // Plugin shutdown logic
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    /**
     * Purely for testing purposes so I can access an 'instance' of RubyLib
     * @return
     */
    public static RubyLib getInstance() {
        return instance;
    }
}
