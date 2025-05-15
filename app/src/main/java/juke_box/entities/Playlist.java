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

    public Song getSong(){
        if (songs.isEmpty()) {
            return null; // or throw an exception
        }
        currentSongIndex = (currentSongIndex+1)% songs.size(); 
        return songs.get(currentSongIndex);
    }
    
    public void nextSong(){
        if (!songs.isEmpty()) {
            currentSongIndex = (currentSongIndex+1)% songs.size(); 
        }
    }
    public Void previousSong() {
        if(!songs.isEmpty()){
            currentSongIndex = (currentSongIndex-1+ songs.size())% songs.size(); 
        }
        return null;
    }

    public void addSong(Song song) {
        if(!songs.contains(song)){
            songs.add(song);
        }
    }

    



    
    
}
