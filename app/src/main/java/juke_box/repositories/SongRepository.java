package juke_box.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Optional;

import juke_box.entities.Song;

public class SongRepository implements ISongRepository {
    private final Map<Integer, Song> songs = new HashMap<>();

    // public Song addSong(String name, String artist, String album, String genre) {
    //     Song song = new Song(name, artist, album, genre);
    //     songs.put(song.getSongId(), song);
    //     return song;
    // }

    // public Optional<Song> findById(int id) {
    //     return Optional.fromNullable(songs.get(id));
    // }

    // public List<Song> findAll() {
    //     return new ArrayList<>(songs.values());
    // }

    // public void deleteById(int id) {
    //     songs.remove(id);
    // }
    
    // public void deleteAll() {
    //     songs.clear();
    // }

    @Override
    public void addSong(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song cannot be null");
        }
        songs.put(song.getSongId(), song);
    }

    @Override
    public Optional<Song> findByName(String name) {
        for (Song song : songs.values()) {
            if (song.getName().equalsIgnoreCase(name)) {
                return Optional.of(song);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Song> findById(int id) {
        return Optional.ofNullable(songs.get(id));
    }

    @Override
    public List<Song> findAll() {
        // TODO Auto-generated method stub
        return new ArrayList<>(songs.values());
    }

    @Override
    public void deleteById(int id) {
        if (songs.containsKey(id)) {
            songs.remove(id);
        } else {
            throw new IllegalArgumentException("Song with ID " + id + " does not exist");
        }
    }

    @Override
    public void deleteAll() {
        songs.clear();
    }
    
}
