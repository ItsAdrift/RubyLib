package me.itsadrift.rubylib.arena.generation;

import org.bukkit.Location;

public interface IArenaGenerator {

    /**
     * Generates the arena and returns the center location
     * @return
     */
    Location generate();

}
