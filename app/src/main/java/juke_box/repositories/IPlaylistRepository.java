package juke_box.repositories;

import java.util.List;
import java.util.Optional;

import juke_box.entities.Playlist;

public interface IPlaylistRepository {
    void addPlaylist(Playlist playlist);
    Optional<Playlist> findByName(String name);
    void delete (String name);
    List<Playlist> findAll();

    boolean exists(String name);
    
    


    
}
