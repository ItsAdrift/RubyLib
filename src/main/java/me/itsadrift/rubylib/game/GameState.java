package me.itsadrift.rubylib.game;

public enum GameState {

    WAITING, // Lobby/timer
    START, // Timer has reached 0, teleport to spawn locations etc
    RUNNING, // The game is now in play
    ENDING, // Victory dances etc
    ENDED; // Game ended, teleport players away & reset arena

}
