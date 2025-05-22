package juke_box.services;

import org.checkerframework.checker.units.qual.s;

import juke_box.entities.Playlist;
import juke_box.repositories.PlaylistRepository;
import juke_box.repositories.SongRepository;

public class SongService {
    private final SongRepository songRepository;

     public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public void addSong(String songName,String artistName, String albumName , String genreName) {
        songRepository.addSong(songName, artistName, albumName, genreName);
        
    }
    public void deleteSong(int songId) {
        songRepository.deleteById(songId);
    }



    
}
