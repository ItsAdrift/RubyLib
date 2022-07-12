package me.itsadrift.rubylib.arena;

import me.itsadrift.rubylib.arena.generation.IArenaGenerator;
import me.itsadrift.rubylib.minigame.player.GameParticipant;

import java.util.List;

/**
 * an Arena is the PHYSICAL arena and everything related to it. (Spawn locations, generators, chests,
 */
public class Arena {

    private IArenaGenerator generator;

    private List<GameParticipant> players;
    public Arena(List<GameParticipant> players, IArenaGenerator generator) {
        this.generator = generator;

        this.players = players;
    }

    public List<GameParticipant> getPlayers() {
        return players;
    }

    public void broadcast(String s) {
        getPlayers().forEach(player -> player.sendMessage(s));
    }
}
