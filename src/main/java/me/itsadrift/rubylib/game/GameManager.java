package me.itsadrift.rubylib.game;

import me.itsadrift.rubylib.RubyLib;
import me.itsadrift.rubylib.arena.Arena;
import me.itsadrift.rubylib.arena.generation.IArenaGenerator;
import me.itsadrift.rubylib.minigame.events.MinigameJoinEvent;
import me.itsadrift.rubylib.minigame.events.MinigameLeaveEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameManager {

    // Game ID, Minigame
    private HashMap<UUID, Game> instances = new HashMap<>();

    private static GameManager instance;
    public GameManager() {
        instance = this;
    }

    public static GameManager getInstance() {
        return instance;
    }

    public Game createGame(Game game) {
        UUID uuid = UUID.randomUUID();
        instances.put(uuid, game);
        game.setUUID(uuid);

        Bukkit.getPluginManager().registerEvents(game, RubyLib.getInstance());

        return game;
    }

    /**
     * Attempts to join a game
     * @param game The game to join
     * @param player The player to join
     * @param obeyMaxPlayers If we should care about the GameSetting's maxPlayers
     * @return returns false if the lobby was full
     *
     * @see Game
     * @see GameSettings
     * @see MinigameJoinEvent
     */
    public boolean joinGame(Game game, Player player, boolean obeyMaxPlayers) {
        if ((game.getPlayers().size() >= game.getGameSettings().getMaxPlayers()) && obeyMaxPlayers)
            return false;
        MinigameJoinEvent e = new MinigameJoinEvent(game, player);
        Bukkit.getPluginManager().callEvent(e);
        if (!e.isCancelled()) {
            game.join(player);
        }
        return true;
    }

    /**
     * Remove a player from a game
     * @param game The game to leave
     * @param player The player
     *
     * @see MinigameLeaveEvent
     */
    public void leaveGame(Game game, Player player) {
        MinigameLeaveEvent e = new MinigameLeaveEvent(game, player);
        Bukkit.getPluginManager().callEvent(e);
        game.leave(player);
    }

    /**
     * Get the Game that a player is participating in
     * @param playerUUID - The player to look for
     * @return
     */
    public Game getGameByPlayer(UUID playerUUID) {
       for (Map.Entry<UUID, Game> e : instances.entrySet()) {
           if (e.getValue().getPlayers().contains(playerUUID)) {
               return e.getValue();
           }
       }

        return null;
    }

}
