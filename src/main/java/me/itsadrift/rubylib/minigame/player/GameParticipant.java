package me.itsadrift.rubylib.minigame.player;

import me.itsadrift.rubylib.game.Game;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public abstract class GameParticipant {

    protected Player player;
    protected Game minigame;

    public GameParticipant(Player player, Game minigame) {
        this.player = player;
        this.minigame = minigame;
    }

    public void teleport(GameParticipant participant) {
        player.teleport(participant.player);
    }

    public void teleport(Location location) {
        player.teleport(location);
    }

    public Location getLocation() {
        return player.getLocation();
    }

    public String getName() {
        return player.getName();
    }

    public UUID getUUID() {
        return player.getUniqueId();
    }

    public Player getPlayer() {
        return player;
    }

}
