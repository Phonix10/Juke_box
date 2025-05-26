package juke_box.commands;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import juke_box.entities.Playlist;
import juke_box.services.PlaylistService;

public class CreatePlaylistCommand implements ICommand {
    private final PlaylistService playlistService;

    public CreatePlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // Check if tokens list is valid
        if (tokens.size() < 2) {
            throw new IllegalArgumentException("Invalid command format.");
        }

        // Extract the playlist name (2nd token)
        String playlistName = tokens.get(1);

        // Extract song IDs from the remaining tokens (starting from the 3rd token)
        List<Integer> songIds = tokens.subList(2, tokens.size()).stream()
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList()); // Use Collectors.toList() instead of toList()

        // Create the playlist with the given name and song IDs
        Playlist playlist = playlistService.createPlaylist(playlistName, songIds);

        // Print the playlist ID to match the expected output
        System.out.println("Playlist [id=" + playlist.getPlaylistId() + "]");
    }
}
