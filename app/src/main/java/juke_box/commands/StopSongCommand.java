package juke_box.commands;

import java.util.List;
import java.util.Optional;

import juke_box.services.SongService;

public class StopSongCommand implements ICommand {
    private final SongService songService;

    public StopSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        try {
            // Check if a song is currently playing
            if (songService.isSongPlating()) {
                songService.stopSong();
                System.out.println("Song stopped.");
            } else {
                System.out.println("No song is currently playing to stop.");
            }
        } catch (RuntimeException e) {
            System.out.println("Error executing command: " + e.getMessage());
        }
    }
}


