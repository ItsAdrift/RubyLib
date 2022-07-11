package me.itsadrift.rubylib.minigame.player;

import me.itsadrift.rubylib.game.Game;
import me.itsadrift.rubylib.minigame.teams.Team;
import org.bukkit.entity.Player;

public class AlivePlayer extends GameParticipant {

    private Team team;

    public AlivePlayer(Player player, Game minigame) {
        super(player, minigame);
    }

    public Team getTeam() {
        return team;
    }
}
