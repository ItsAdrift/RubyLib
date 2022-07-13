package me.itsadrift.rubylib.game.teamsorting;

import me.itsadrift.rubylib.game.Game;
import me.itsadrift.rubylib.minigame.player.GameParticipant;
import me.itsadrift.rubylib.minigame.teams.Team;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DefaultTeamSorting extends TeamSorter {
    public DefaultTeamSorting(Game game, int playersPerTeam) {
        super(game, playersPerTeam);
    }

    @Override
    public void sort(List<Team> teams, List<GameParticipant> players) {
        List<List<GameParticipant>> split = split(players, players.size() / playersPerTeam);

        int teamIndex = 0;
        for (List<GameParticipant> l : split) {
            Team team = teams.get(teamIndex);
            team.addAll(l);

            l.forEach(player -> player.setTeam(team));

            teamIndex++;
        }
    }

    public <T> List<List<T>> split(List<T> list, int size)
            throws NullPointerException, IllegalArgumentException {
        if (list == null) {
            throw new NullPointerException("The list parameter is null.");
        }

        if (size <= 0) {
            throw new IllegalArgumentException(
                    "The size parameter must be more than 0.");
        }

        List<List<T>> result = new ArrayList<List<T>>(size);

        for (int i = 0; i < size; i++) {
            result.add(new ArrayList<T>());
        }

        int index = 0;

        for (T t : list) {
            result.get(index).add(t);
            index = (index + 1) % size;
        }

        return result;
    }
}
