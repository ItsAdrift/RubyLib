package me.itsadrift.rubylib.game.teamsorting;

import me.itsadrift.rubylib.game.Game;
import me.itsadrift.rubylib.minigame.player.GameParticipant;
import me.itsadrift.rubylib.minigame.teams.Team;
import org.apache.commons.lang.NotImplementedException;

import java.util.List;

public abstract class TeamSorter {

    public Game game;
    public int playersPerTeam;
    public TeamSorter(Game game, int playersPerTeam) {
        this.game = game;
        this.playersPerTeam = playersPerTeam;
    }

    public void sort(List<Team> teams, List<GameParticipant> players) {
        throw new NotImplementedException("TeamSorter#sort is not implemented. Please use a class that extends TeamSorter");
    }

}
