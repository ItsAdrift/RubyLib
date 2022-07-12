package me.itsadrift.rubylib.game;

import me.itsadrift.rubylib.arena.Arena;
import me.itsadrift.rubylib.minigame.events.MinigameStateChangeEvent;
import me.itsadrift.rubylib.minigame.player.GameParticipant;
import me.itsadrift.rubylib.minigame.teams.Team;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public abstract class Game implements Listener {

    private String id;
    private UUID uuid;
    private GameSettings gameSettings;

    private Arena arena;
    private GameState gameState;

    private HashMap<String, Team> teams = new HashMap<>();
    private final List<GameParticipant> players = new ArrayList<>();


    public Game(String id, GameSettings gameSettings) {
        this.id = id;
        this.gameSettings = gameSettings;

        setGameState(GameState.WAITING);
    }

    public abstract void onStartGame();
    public abstract void onStopGame();
    public abstract void tickSecond();

    public GameParticipant getPlayer(Player player) {
        return  getPlayer(player.getUniqueId());
    }

    public GameParticipant getPlayer(UUID uuid) {
        for (GameParticipant p : players) {
            if (p.getUUID().equals(uuid))
                return p;
        }

        return null;
    }

    public Arena getArena() {
        return arena;
    }

    public List<GameParticipant> getPlayers() {
        return players;
    }

    public void broadcast(String s) {
        getArena().broadcast(s);
    }

    public String getId() {
        return id;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUUID() {
        return uuid;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void registerTeam(String id, Team team) {
        teams.put(id, team);
    }

    public void unregisterTeam(String id) {
        teams.remove(id);
    }

    public Team getTeam(String id) {
        return teams.get(id);
    }

    public void setGameState(GameState gameState) {
        MinigameStateChangeEvent e = new MinigameStateChangeEvent(this, this.gameState, gameState);
        Bukkit.getPluginManager().callEvent(e);
        if (e.isCancelled())
            return;
        this.gameState = e.getNewGameState();
    }
}
