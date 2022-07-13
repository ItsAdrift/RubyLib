package me.itsadrift.rubylib.arena.location;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class ArenaLocation {

    private String name;
    private List<Location> locations;

    public ArenaLocation(String name, Location location) {
        this.name = name;
        this.locations.add(location);
    }

    public ArenaLocation(String name, List<Location> location) {
        this.name = name;
        this.locations = new ArrayList<>(location);
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return locations.get(0);
    }

    public List<Location> getLocations() {
        return locations;
    }

}
