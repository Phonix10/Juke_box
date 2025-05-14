package juke_box.entities;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private static int idCounter = 1;
    private final int playlistId;
    private final String name;
    private final List<Song> songs;
    private int currentSongIndex;

    public Playlist(String name) {
        this.playlistId = idCounter++;
        this.name = name;
        this.songs = new ArrayList<>();
        this.currentSongIndex = 0;
    }
    public int getPlaylistId() {
        return playlistId;
    }
    public String getName() {
        return name;
    }

    
    
}
