package me.itsadrift.rubylib;

import me.itsadrift.rubylib.game.GameManager;
import me.itsadrift.rubylib.minigame.listeners.DeathListener;
import me.itsadrift.rubylib.minigame.listeners.DeathMessageListener;
import me.itsadrift.rubylib.minigame.listeners.Tracker;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class RubyLib extends JavaPlugin {
    private GameManager gameManager;
    private static RubyLib instance; // Testing purposes

    // https://github.com/redwallhp/AthenaGM

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new DeathMessageListener(this), this);
        pm.registerEvents(new Tracker(this), this);
        pm.registerEvents(new DeathListener(), this);

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
