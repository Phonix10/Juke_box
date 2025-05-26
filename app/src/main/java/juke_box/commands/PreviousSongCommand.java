package juke_box.commands;

import java.util.List;
import java.util.Optional;

import juke_box.entities.Song;
import juke_box.services.SongService;

public class PreviousSongCommand implements ICommand {
    private final SongService songService;

    public PreviousSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        try {
            Song previousSong = songService.previousSong(); // Get the previous song
            System.out.println("Previous song is: " + previousSong.getName());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}



