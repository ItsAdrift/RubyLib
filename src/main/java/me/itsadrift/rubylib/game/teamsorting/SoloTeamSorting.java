package me.itsadrift.rubylib.game.teamsorting;

import me.itsadrift.rubylib.game.Game;
import me.itsadrift.rubylib.minigame.player.GameParticipant;
import me.itsadrift.rubylib.minigame.teams.Team;
import org.bukkit.ChatColor;

import java.util.List;

/**
 * Team sorting used for solo gamemodes (1 player per team)
 */
public class SoloTeamSorting extends TeamSorter {

    public SoloTeamSorting(Game game, int playersPerTeam) {
        super(game, playersPerTeam);
    }

    @Override
    public void sort(List<Team> teams, List<GameParticipant> players) {
        for (GameParticipant player : players) {
            Team team = new Team(player.getName(), ChatColor.GRAY);
            team.addPlayer(player);
            player.setTeam(team);
            game.registerTeam(player.getName(), team);
        }
    }
}
