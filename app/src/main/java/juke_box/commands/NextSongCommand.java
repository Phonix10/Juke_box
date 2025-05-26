package juke_box.commands;

import java.util.List;
import java.util.Optional;

import juke_box.entities.Song;
import juke_box.services.SongService;

public class NextSongCommand implements ICommand {
    private final SongService songService;

    public NextSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        try {
            Song nextSong = songService.nextSong(); // Get the next song
            System.out.println("Next song is: " + nextSong.getName());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}


