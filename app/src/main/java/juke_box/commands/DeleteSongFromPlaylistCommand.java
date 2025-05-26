package juke_box.commands;

import java.util.List;
import java.util.Optional;

import juke_box.entities.Playlist;
import juke_box.entities.Song;
import juke_box.services.PlaylistService;
import juke_box.services.SongService;

public class DeleteSongFromPlaylistCommand implements ICommand {
    private final PlaylistService playlistService;
    private final SongService songService;

    public DeleteSongFromPlaylistCommand(PlaylistService playlistService, SongService songService) {
        this.playlistService = playlistService;
        this.songService = songService;
    }

    // @Override
    // public void invoke(List<String> tokens) {
    //     String playlistName = tokens.get(1);
    //     int songId = Integer.parseInt(tokens.get(2));

    //     // Load the playlist
    //     Playlist playlist = playlistService.loadPlaylist(playlistName);

    //     // Retrieve the song by ID
    //     Song song = songService.getSongById(songId)
    //             .orElseThrow(() -> new RuntimeException("Song not found: " + songId)); // Properly handles Optional

    //     // Remove the song from the playlist
    //     playlistService.removeSongFromPlaylist(playlistName, song);

        
    // }

    @Override
public void invoke(List<String> tokens) {
    if (tokens.size() != 3) {
        System.out.println("Error: Invalid arguments for REMOVE_SONG_FROM_PLAYLIST. Expected 2 arguments (playlistName songId).");
        return;
    }

    String playlistName = tokens.get(1);
    int songId;

    try {
        songId = Integer.parseInt(tokens.get(2));
    } catch (NumberFormatException e) {
        System.out.println("Error: Invalid song id. It should be a number.");
        return;
    }

    // Load the playlist
    Playlist playlist = playlistService.loadPlaylist(playlistName);

    // Remove the song from the playlist using songId
    playlistService.removeSongFromPlaylist(playlistName, songId);

    // Reload the updated playlist to show the revised state
    Playlist updatedPlaylist = playlistService.loadPlaylist(playlistName);

    // Final output showing the revised playlist
    System.out.println("Playlist " + playlistName + " is revised with " + formatSongList(updatedPlaylist.getSongs()));
}

// Helper method to format the list of songs
private String formatSongList(List<Song> songs) {
    if (songs.isEmpty()) {
        return "[]";
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
    return output.toString();
}
}
