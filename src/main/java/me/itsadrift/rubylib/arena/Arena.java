package me.itsadrift.rubylib.arena;

import me.itsadrift.rubylib.arena.generation.IArenaGenerator;
import me.itsadrift.rubylib.arena.location.ArenaLocation;
import me.itsadrift.rubylib.minigame.player.GameParticipant;

import java.util.HashMap;
import java.util.List;

/**
 * an Arena is the PHYSICAL arena and everything related to it. (Spawn locations, generators, chests,
 */
public class Arena {

    private IArenaGenerator generator;
    private HashMap<String, ArenaLocation> locations = new HashMap<>();

    public Arena(IArenaGenerator generator) {
        this.generator = generator;
    }

    public void addLocation(ArenaLocation location) {
        locations.put(location.getName(), location);
    }
}
