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

    private final HashMap<String, Team> teams = new HashMap<>();
    private final List<GameParticipant> players = new ArrayList<>();

    public Game(String id, GameSettings gameSettings) {
        this.id = id;
        this.gameSettings = gameSettings;

        setGameState(GameState.WAITING);
    }

    public abstract void onStart();
    private void start() {
        // Team sorting- taking into account a party system
    }
    public abstract void onStop();
    private void stop() {

    }
    public abstract void tickSecond();

    public GameParticipant getPlayer(Player player) {
        return getPlayer(player.getUniqueId());
    }

    public GameParticipant getPlayer(UUID uuid) {
        for (GameParticipant p : players) {
            if (p.getUUID().equals(uuid))
                return p;
        }

        return null;
    }

    public void join(Player player) {
        GameParticipant p = new GameParticipant(player, this);
        players.add(p);
    }

    public void leave(Player player) {
        players.remove(getPlayer(player));
    }

    /**
     * Register a new team
     * @param id - The id used to identify the team
     * @param team - The team object
     */
    public void registerTeam(String id, Team team) {
        teams.put(id, team);
    }

    /**
     * Unregister a team
     * @param id - he id used to identify the team
     */
    public void unregisterTeam(String id) {
        teams.remove(id);
    }

    /**
     * Get a team
     * @param id - The id used to identify the team
     * @return The team identified by id
     */
    public Team getTeam(String id) {
        return teams.get(id);
    }

    /**
     * Broadcast a message to all players involved in a game
     * @param message - The message to send
     */
    public void broadcast(String message) {
        getPlayers().forEach(player -> player.sendMessage(message));
    }

    /**
     * Change the game state of a game
     * @param gameState - The new game state
     * @see GameState
     */
    public void setGameState(GameState gameState) {
        MinigameStateChangeEvent e = new MinigameStateChangeEvent(this, this.gameState, gameState);
        Bukkit.getPluginManager().callEvent(e);
        if (e.isCancelled())
            return;
        this.gameState = e.getNewGameState();
    }

    /*
        Getters/Setters
     */

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) { this.arena = arena; }

    public List<GameParticipant> getPlayers() {
        return players;
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

    public GameSettings getGameSettings() {
        return gameSettings;
    }
}
