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
    public Song getNextSong() {
        if (songs.isEmpty()) {
            return null;  // No songs in the playlist
        }
        currentSongIndex = (currentSongIndex + 1) % songs.size();  
        return songs.get(currentSongIndex);
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song) {
        if (!songs.contains(song)) {  // Prevent duplicate songs
            songs.add(song);
        }
    }
    

    public void removeSong(Song song) {
        songs.remove(song);
        // Adjust currentSongIndex if necessary
        if (currentSongIndex >= songs.size()) {
            currentSongIndex = songs.size() - 1;
        }
    }

    public List<Song> getSongs() {
        return new ArrayList<>(songs); // Return a copy to preserve encapsulation
    }

    public Song getCurrentSong() {
        if (songs.isEmpty()) {
            throw new RuntimeException("No songs in the playlist");
        }
        return songs.get(currentSongIndex);
    }

    public void nextSong() {
        if (!songs.isEmpty()) {
            currentSongIndex = (currentSongIndex + 1) % songs.size();
        }
    }

    public void previousSong() {
        if (!songs.isEmpty()) {
            currentSongIndex = (currentSongIndex - 1 + songs.size()) % songs.size();
        }
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistId=" + playlistId +
                ", name='" + name + '\'' +
                ", songs=" + songs +
                ", currentSongIndex=" + currentSongIndex +
                '}';
    }

    



    
    
}
