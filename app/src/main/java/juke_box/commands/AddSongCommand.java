package juke_box.commands;

import java.util.List;

import juke_box.entities.Song;
import juke_box.services.SongService;

public class AddSongCommand implements ICommand {
    private final SongService songService;

    public AddSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        if (tokens.size() < 5) {
            System.out.println("Error: Invalid number of arguments. Usage: ADD_SONG <name> <artist> <album> <genre>");
            return;
        }

        String name = tokens.get(1);
        String artist = tokens.get(2);
        String album = tokens.get(3);
        String genre = tokens.get(4);

        Song song = songService.addSong(name, artist, album, genre);
        System.out.println("Song [id=" + song.getSongId() + "]");
    }
    
}
