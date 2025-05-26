package juke_box.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Optional;

import juke_box.entities.Playlist;


public class PlaylistRepository implements IPlaylistRepository {
    private final Map<String, Playlist> playlists = new HashMap<>();

    @Override
    public void addPlaylist(Playlist playlist) {
        playlists.put(playlist.getName(), playlist);
    }

    
    @Override
    public Optional<Playlist> findByName(String name) {
        return Optional.ofNullable(playlists.get(name));
    }

    @Override
    public void delete(String name) {
        playlists.remove(name);
    }

    @Override
    public List<Playlist> findAll() {
        return new ArrayList<>(playlists.values());
    }


    @Override
    public boolean exists(String name) {
        // TODO Auto-generated method stub
        
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("playlist cannot be found ");
        }
        return playlists.containsKey(name);
    }
    
}
