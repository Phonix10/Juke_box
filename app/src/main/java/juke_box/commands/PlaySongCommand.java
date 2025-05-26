package juke_box.commands;

import java.util.List;
import java.util.Optional;

import juke_box.entities.Song;
import juke_box.services.SongService;

public class PlaySongCommand implements ICommand {
    private final SongService songService;

    public PlaySongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // No need to check for tokens or arguments as this command takes none.

        List<Song> songQueue = songService.getSongQueue();
        System.out.println("Current song queue: " + songQueue); // added log to check song queue
        if (songQueue.isEmpty()) {
            System.out.println("No songs available in playlist to play.");
            return;
        }
        
        Song songToPlay = songQueue.get(0); // Play the first song in the queue
        System.out.println("Song [id=" + songToPlay.getSongId() + "] is playing!");
        songQueue.remove(0); // Remove the song after playing
    }
}

