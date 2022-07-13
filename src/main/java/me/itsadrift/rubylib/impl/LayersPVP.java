package me.itsadrift.rubylib.impl;

import me.itsadrift.rubylib.game.Game;
import me.itsadrift.rubylib.game.GameSettings;
import me.itsadrift.rubylib.game.teamsorting.DefaultTeamSorting;
import me.itsadrift.rubylib.minigame.events.MinigameJoinEvent;
import me.itsadrift.rubylib.minigame.events.MinigameWinEvent;
import me.itsadrift.rubylib.minigame.teams.Team;
import me.itsadrift.rubylib.utils.RandomEnum;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;

/**
 * Extends on the 'Game' class, handles actual gameplay, etc.
 * When creating a new match of LayersPVP, call GameManager.createGame(Game) GameManager.createGame(new LayersPVP(GameSettings));
 * to create a new instance of LayersPVP, as well as assign an arena
 */
public class LayersPVP extends Game {

    public LayersPVP(GameSettings gameSettings) {
        super("layerspvp", gameSettings);
        setTeamSorter(new DefaultTeamSorting(this, 2));

        RandomEnum<ChatColor> randomEnum = new RandomEnum<>(ChatColor.class);
        for (int i = 0; i < 10; i++) {
            registerTeam("team"+i, new Team("Team 1", randomEnum.random(ChatColor.BOLD, ChatColor.MAGIC, ChatColor.STRIKETHROUGH, ChatColor.UNDERLINE, ChatColor.MAGIC, ChatColor.ITALIC)));
        }

        // Handle Arena
    }

    @Override
    public void onStart() {
        // teleport players to their spawn location
        // start timer for layers to disappear
        // make layers disappear
        // repeat until you get to the final layer
    }

    @EventHandler
    public void onWin(MinigameWinEvent e) {
        if (!e.appliesToGame(this))
            return;
        e.getTeam().getPlayers().forEach(player -> player.sendMessage("gj u won"));
        broadcast(e.getTeam().getColor() + ChatColor.BOLD.toString() + e.getTeam().getName() + " has won!");
    }

    @Override
    public void onStop() {
        // teleport all players/spectators to spawn
        // reset/clear arena
    }

    @Override
    public void tickSecond() {
        // update countdown scoreboard
        // use this to time layers disappearing
    }

    @EventHandler
    public void onJoin(MinigameJoinEvent e) {
        if (!e.appliesToGame(this))
            return;


    }

}
