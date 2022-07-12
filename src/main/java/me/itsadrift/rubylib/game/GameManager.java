package me.itsadrift.rubylib.game;

import me.itsadrift.rubylib.RubyLib;
import org.bukkit.Bukkit;

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
     * Get the Game that a player is participating in
     * @param playerUUID - The player to look for
     * @return
     */
    public Game getGameByPlayer(UUID playerUUID) {
       for (Map.Entry<UUID, Game> e : instances.entrySet()) {
           if (e.getValue().getArena().getPlayers().contains(playerUUID)) {
               return e.getValue();
           }
       }

        return null;
    }

}
