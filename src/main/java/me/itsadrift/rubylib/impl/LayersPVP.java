package me.itsadrift.rubylib.impl;

import me.itsadrift.rubylib.game.Game;
import me.itsadrift.rubylib.game.GameSettings;
import me.itsadrift.rubylib.minigame.events.MinigameDeathEvent;
import me.itsadrift.rubylib.minigame.events.MinigameWinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Extends on the 'Game' class, handles actual gameplay, etc.
 * When creating a new match of LayersPVP, call GameManager.createGame(Game) GameManager.createGame(new LayersPVP(GameSettings));
 * to create a new instance of LayersPVP, as well as assign an arena
 */
public class LayersPVP extends Game {

    public LayersPVP(GameSettings gameSettings) {
        super("layerspvp", gameSettings);


    }

    @Override
    public void onStartGame() {
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
    }

    @Override
    public void onStopGame() {
        // teleport all players/spectators to spawn
        // reset/clear arena
    }

    @Override
    public void tickSecond() {
        // update countdown scoreboard
        // use this to time layers disappearing
    }
}
