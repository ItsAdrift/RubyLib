package me.itsadrift.rubylib.commands;

import me.itsadrift.rubylib.game.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Command to handle joining, leaving, starting, stopping games etc.
 * API users can set an alias for this command
 */
public class GameCommand implements CommandExecutor {

    private GameManager gameManager;
    public GameCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {



        return false;
    }
}

