package juke_box.commands;

import java.util.List;
import java.util.Optional;

import juke_box.services.SongService;

public class CreateSongCommand implements ICommand {
    private final SongService songService;

    public CreateSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        if (tokens.size() < 5) {
            System.out.println("Error: Invalid number of arguments. Usage: CREATE_SONG <name> <artist> <album> <genre>");
            return;
        }

        String name = tokens.get(1);
        String artist = tokens.get(2);
        String album = tokens.get(3);
        String genre = tokens.get(4);

        songService.createSong(name, artist, album, genre);
        System.out.println("Song created: " + name);
    }
}

