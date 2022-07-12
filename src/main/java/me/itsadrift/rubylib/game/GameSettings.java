package me.itsadrift.rubylib.game;

import org.bukkit.configuration.file.FileConfiguration;

public class GameSettings {

    private ArenaType arenaType;
    private ArenaLoad arenaLoad;

    /**
     * If the ArenaType is SINGLE and ArenaLoad is NONE (meaning that there is only one arena on the server),
     * set these values to allow for grabbing from config
     */
    private FileConfiguration config;
    private String configPath;

    public GameSettings(ArenaType arenaType, ArenaLoad arenaLoad) {
        this.arenaType = arenaType;
        this.arenaLoad = arenaLoad;
    }

    public ArenaType getArenaType() {
        return arenaType;
    }

    public ArenaLoad getArenaLoad() {
        return arenaLoad;
    }

    public enum ArenaType {
        SINGLE,
        MULTI;
    }

    public enum ArenaLoad {
        NONE,
        WORLD,
        SCHEMATIC;
    }

}
