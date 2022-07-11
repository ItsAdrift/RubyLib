package me.itsadrift.rubylib.minigame.teams;

import org.bukkit.ChatColor;

public class Team {

    private String name;
    private ChatColor color;

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
}
