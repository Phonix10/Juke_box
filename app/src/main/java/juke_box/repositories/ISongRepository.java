package juke_box.repositories;

import java.util.List;
import java.util.Optional;

import juke_box.entities.Song;

public interface ISongRepository {
    void addSong(Song song); // Save a song to the repository

    Optional<Song> findById(int id); // Find a song by ID

    Optional<Song> findByName(String name); // Find a song by name

    List<Song> findAll(); // Retrieve all songs

    void deleteById(int id); // Delete a song by ID

    void deleteAll(); // Delete all songs

    
}
