package juke_box.commands;

import java.util.List;
import java.util.Optional;

import juke_box.services.PlaylistService;

public class ListPlaylistsCommand implements ICommand {
    private final PlaylistService playlistService;

    public ListPlaylistsCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        playlistService.getAllPlaylists().forEach(System.out::println);
    }
}
