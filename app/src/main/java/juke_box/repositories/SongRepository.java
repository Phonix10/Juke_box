package juke_box.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Optional;

import juke_box.entities.Song;

public class SongRepository {
    private final Map<Integer, Song> songs = new HashMap<>();

        public Song addSong(String name, String artist, String album, String genre) {
        Song song = new Song(name, artist, album, genre);
        songs.put(song.getSongId(), song);
        return song;
    }

    public Optional<Song> findById(int id) {
        return Optional.fromNullable(songs.get(id));
    }

    public List<Song> findAll() {
        return new ArrayList<>(songs.values());
    }

    public void deleteById(int id) {
        songs.remove(id);
    }
    
    public void deleteAll() {
        songs.clear();
    }
    
}
