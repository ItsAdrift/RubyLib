package me.itsadrift.rubylib.minigame.teams;

import me.itsadrift.rubylib.minigame.player.GameParticipant;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Team {

    private String name;
    private ChatColor color;

    private List<GameParticipant> players = new ArrayList<>();

    public Team(String name, ChatColor color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }

    public void addPlayer(GameParticipant player) {
        players.add(player);
    }

    public void addAll(List<GameParticipant> l) { players.addAll(l); }

    public void removePlayer(GameParticipant player) {
        players.remove(player);
    }

    public List<GameParticipant> getPlayers() {
        return players;
    }

    public List<GameParticipant> getAlivePlayers() {
        return players.stream().filter(GameParticipant::isAlive).collect(Collectors.toList());
    }
}
