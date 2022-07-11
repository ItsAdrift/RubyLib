package me.itsadrift.rubylib.arena;

import me.itsadrift.rubylib.minigame.player.GameParticipant;

import java.util.List;
import java.util.UUID;

/**
 * an Arena is the PHYSICAL arena and everything related to it. (Spawn locations, generators, chests,
 */
public class Arena {

    private List<GameParticipant> players;
    public Arena(List<GameParticipant> players) {
        this.players = players;
    }

    public List<GameParticipant> getPlayers() {
        return players;
    }
}
