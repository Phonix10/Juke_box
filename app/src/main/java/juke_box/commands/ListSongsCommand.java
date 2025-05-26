
package juke_box.commands;

import java.util.List;
import java.util.Optional;

import juke_box.entities.Song;
import juke_box.services.SongService;

public class ListSongsCommand implements ICommand {
    private final SongService songService;

    public ListSongsCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        List<Song> songs = songService.findAll();

        if (songs.isEmpty()) {
            System.out.println("No songs available.");
            return;
        }

        StringBuilder output = new StringBuilder("[");
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            output.append("Song [id=").append(song.getSongId()).append("]");
            if (i < songs.size() - 1) {
                output.append(", ");
            }
        }
        output.append("]");
        System.out.println(output.toString());
    }
}


