package juke_box.commands;

import java.util.List;
import java.util.Optional;

import juke_box.entities.Playlist;
import juke_box.services.PlaylistService;

public class LoadPlaylistCommand implements ICommand {
    private final PlaylistService playlistService;

    public LoadPlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        if (tokens.size() < 2) {
            System.out.println("Error: Invalid number of arguments. Usage: LOAD_PLAYLIST <playlistName>");
            return;
        }
        
        String playlistName = tokens.get(1);
        try {
            Playlist playlist = playlistService.loadPlaylist(playlistName);
            System.out.println("Playlist " + playlistName + " is loaded!");
        } catch (RuntimeException e) {
            System.out.println("Error executing command: " + e.getMessage());
        }
    }
}


