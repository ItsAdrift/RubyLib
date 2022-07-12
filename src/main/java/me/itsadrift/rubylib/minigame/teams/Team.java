package me.itsadrift.rubylib.minigame.teams;

import me.itsadrift.rubylib.minigame.player.GameParticipant;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

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

    public void removePlayer(GameParticipant player) {
        players.remove(player);
    }

    public List<GameParticipant> getPlayers() {
        return players;
    }
}
