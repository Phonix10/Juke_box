package juke_box.commands;

import java.util.List;
import java.util.Optional;

import juke_box.entities.Song;
import juke_box.services.SongService;

public class GetSongCommand implements ICommand {
    private final SongService songService;

    public GetSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        if (tokens.size() < 2) {
            System.out.println("Error: Invalid number of arguments. Usage: GET_SONG <songName>");
            return;
        }

        String songName = tokens.get(1);

        Song song = songService.getSongByName(songName);
        if (song == null) {
            System.out.println("Error: Song not found.");
            return;
        }

        System.out.println("Song: " + song);
    }
}
