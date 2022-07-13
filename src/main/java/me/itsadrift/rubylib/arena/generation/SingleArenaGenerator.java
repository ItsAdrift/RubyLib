package me.itsadrift.rubylib.arena.generation;

import me.itsadrift.rubylib.arena.Arena;
import me.itsadrift.rubylib.arena.location.ArenaLocation;
import me.itsadrift.rubylib.game.Game;
import me.itsadrift.rubylib.utils.LocUtils;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * The generator (loader) for a minigame that only runs one game at a time, and only has a single arena
 */
public class SingleArenaGenerator implements IArenaGenerator{

    private Arena arena;
    private FileConfiguration config;
    private String gameId;
    private String path;
    public SingleArenaGenerator(Arena arena, FileConfiguration config, String id, String path) {
        this.arena = arena;
        this.config = config;
        this.gameId = id;
        this.path = path;
    }

    @Override
    public Location generate() {
        for (String key : config.getConfigurationSection(gameId + path).getKeys(false)) {
            if (config.getStringList(gameId + path + "." + key).size() > 0) {
                List<String> l = config.getStringList(gameId + path + "." + key);
                List<Location> locations = new ArrayList<>();
                l.forEach(s -> locations.add(LocUtils.getLocationString(s)));

                arena.addLocation(new ArenaLocation(key, locations));
            } else {
                arena.addLocation(new ArenaLocation(key, LocUtils.getLocationString(config.getString(gameId + path + "." + key))));
            }

        }
        return null;
    }
}
