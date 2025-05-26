package juke_box.services;

import juke_box.repositories.*;
import juke_box.entities.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;


public class PlaylistService {
    private final IPlaylistRepository playlistRepository;
    private ISongRepository songRepository;

    public PlaylistService(ISongRepository songRepository, IPlaylistRepository playlistRepository) {
        this.songRepository = songRepository;
        this.playlistRepository = playlistRepository;
    }

    public void executeCreatePlaylistCommand(String commad){
        

        
        String[] tokens = command.split(" ");

        // Extract the playlist name (2nd token)
        String playlistName = tokens[1];

        // Extract song IDs from the remaining tokens (starting from the 3rd token)
        List<Integer> songIds = new ArrayList<>();
        for (int i = 2; i < tokens.length; i++) {
            songIds.add(Integer.parseInt(tokens[i]));
        }

        // Create the playlist with the given name and song IDs
        createPlaylist(playlistName, songIds);
    }

    private Playlist createPlaylist(String playlistName, List<Integer> songIds) {
        // TODO Auto-generated method stub
        Playlist playlist =  new Playlist(playlistName);

        for(Integer songId : songIds){
            Optional<Song> songs = songRepository.findById(songId);
            if(songs.isPresent()){
                playlist.addSong(songs.get());
            }else{
                System.out.println("Song with ID " + songId + " not found.");
            }
        }
        playlistRepository.addPlaylist(playlist);

        return playlist;

    }

    public void addSongToPlaylist(String playlistName, Song song){
        Optional<Playlist> optionalPlaylist = playlistRepository.findByName(playlistName);
        if(optionalPlaylist.isPresent()){
            Playlist playlist = optionalPlaylist.get();
            playlist.addSong(song);
            playlistRepository.addPlaylist(playlist);
        }
        else{
            throw new RuntimeException("Playlist not found");
        }
    }

    public List<Song> getSongsInPlaylist(String playlistName){
        Playlist playlist = loadPlaylist(playlistName);
        
        return playlist.getSongs();
        

    }

    private Playlist loadPlaylist(String playlistName) {
        if (playlistName == null || playlistName.isEmpty()) {
            throw new IllegalArgumentException("Playlist name cannot be null or empty");
        }

        return playlistRepository.findByName(playlistName)
                .orElseThrow(() -> new RuntimeException("Playlist not found: " + playlistName));
    }

    public void deletePlaylist(String playlistName) {
        if (playlistName == null || playlistName.isEmpty()) {
            throw new IllegalArgumentException("Playlist name cannot be null or empty");
        }
        if (!playlistRepository.exists(playlistName)) {
            throw new RuntimeException("Playlist not found: " + playlistName);
        }
        playlistRepository.delete(playlistName);
    }
    public List<Playlist> getAllPlaylists(){
        return playlistRepository.findAll();
    }

    public void nextSong(String playlistName) {
        if (playlistName == null || playlistName.isEmpty()) {
            throw new IllegalArgumentException("Playlist name cannot be null or empty");
        }

        Playlist playlist = playlistRepository.findByName(playlistName)
                .orElseThrow(() -> new RuntimeException("Playlist not found: " + playlistName));

        playlist.nextSong();  // Ensure the nextSong method is implemented in Playlist class
        playlistRepository.addPlaylist(playlist);
    }

    // Play the previous song in the playlist
    public void previousSong(String playlistName) {
        if (playlistName == null || playlistName.isEmpty()) {
            throw new IllegalArgumentException("Playlist name cannot be null or empty");
        }

        Playlist playlist = playlistRepository.findByName(playlistName)
                .orElseThrow(() -> new RuntimeException("Playlist not found: " + playlistName));

        playlist.previousSong();  // Ensure the previousSong method is implemented in Playlist class
        playlistRepository.addPlaylist(playlist);
    }
    
    public void removeSongFromPlaylist(String playlistName, int songId) {
        Playlist playlist = playlistRepository.findByName(playlistName)
                .orElseThrow(() -> new RuntimeException("Playlist not found: " + playlistName));
    
        Optional<Song> songToRemove = playlist.getSongs().stream()
                .filter(song -> song.getSongId() == songId)
                .findFirst();
    
        songToRemove.ifPresent(song -> {
            playlist.removeSong(song);
            playlistRepository.addPlaylist(playlist);
        });
    }





    
}
