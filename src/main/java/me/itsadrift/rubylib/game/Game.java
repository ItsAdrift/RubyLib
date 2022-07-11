package me.itsadrift.rubylib.game;

import me.itsadrift.rubylib.arena.Arena;
import me.itsadrift.rubylib.minigame.player.AlivePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Game {

    private String id;
    public Game(String id) {
        this.id = id;
    }

    private Arena arena;

    private final List<AlivePlayer> players = new ArrayList<>();

    public Arena getArena() {
        return arena;
    }

    public List<AlivePlayer> getPlayers() {
        return players;
    }

    public AlivePlayer getPlayer(Player player) {
        return  getPlayer(player.getUniqueId());
    }

    public AlivePlayer getPlayer(UUID uuid) {
        for (AlivePlayer p : players) {
            if (p.getUUID().equals(uuid))
                return p;
        }

        return null;
    }

    public void broadcast(String s) {

    }

}
