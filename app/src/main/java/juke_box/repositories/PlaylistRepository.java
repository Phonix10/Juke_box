package juke_box.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Optional;

import juke_box.entities.Playlist;


public class PlaylistRepository {
    private final Map<String, Playlist> playlists = new HashMap<>();

    public void save(Playlist playlist) {
        playlists.put(playlist.getName(), playlist);
    }

    public Optional<Playlist> findByName(String name) {
        return Optional.fromNullable(playlists.get(name));
    }

    public void delete(String name) {
        playlists.remove(name);
    }

    public List<Playlist> findAll() {
        return new ArrayList<>(playlists.values());
    }
    
}
