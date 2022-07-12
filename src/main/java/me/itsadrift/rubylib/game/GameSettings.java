package me.itsadrift.rubylib.game;

import me.itsadrift.rubylib.arena.generation.IArenaGenerator;
import org.bukkit.configuration.file.FileConfiguration;

public class GameSettings {

    private int maxPlayers = 8;

    private ArenaType arenaType;
    private ArenaLoad arenaLoad;

    /**
     * If the ArenaType is SINGLE and ArenaLoad is NONE (meaning that there is only one arena on the server),
     * set these values to allow for grabbing from config
     */
    private FileConfiguration config;
    private String configPath;

    public GameSettings(int maxPlayers, ArenaType arenaType, ArenaLoad arenaLoad) {
        this.maxPlayers = maxPlayers;
        this.arenaType = arenaType;
        this.arenaLoad = arenaLoad;
    }

    public int getMaxPlayers() {
        return maxPlayers;
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
