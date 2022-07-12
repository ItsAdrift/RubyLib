package me.itsadrift.rubylib.minigame.player;

import me.itsadrift.rubylib.game.Game;
import me.itsadrift.rubylib.minigame.teams.Team;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GameParticipant {

    private Team team;
    private Player player;
    private Game minigame;

    private boolean isAlive = true;

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

    public void sendMessage(String s) {
        player.sendMessage(s);
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
