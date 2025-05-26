package juke_box.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.checkerframework.checker.units.qual.s;



import juke_box.entities.Playlist;
import juke_box.entities.Song;
import juke_box.repositories.ISongRepository;
import juke_box.repositories.PlaylistRepository;
import juke_box.repositories.SongRepository;


public class SongService {
    
    private final ISongRepository songRepository;
    private Song currentlyPlayingSong;
    
    private int currentIndex;
    private  List<Song> songQueue = new LinkedList<>();

    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
        this.songQueue = new LinkedList<>();
        this.currentlyPlayingSong = null;
        this.currentIndex = -1; 
    }
    

    public Song addSong(String songName,String artistName, String albumName , String genreName) {
        Song song = new Song(songName, artistName, albumName, genreName);
        songRepository.addSong(song);  
        return song; 
        
        
    }
    public void deleteSong(int songId) {
        songRepository.deleteById(songId);
    }

    public Optional<Song> findById(int songId) {
        return songRepository.findById(songId);
    }

    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public Song getSongByName(String songName) {
        return songRepository.findByName(songName)
                .orElseThrow(() -> new RuntimeException("Song not found: " + songName));
    }

    public void playSong(String songName) {
        Song foundSong  =  getSongByName(songName);
        currentlyPlayingSong =  foundSong;

        songQueue.add(currentlyPlayingSong);
        currentIndex = songQueue.indexOf(currentlyPlayingSong);
        System.out.println("Now playing: " + currentlyPlayingSong.getName() + " by " + currentlyPlayingSong.getArtist());

    }

    public void playSongById(int songId){
        Song foundSong = findById(songId).
                            orElseThrow(() -> new RuntimeException("Song not found: " + songId));
        currentlyPlayingSong = foundSong;
        songQueue.clear();
        songQueue.add(currentlyPlayingSong);
        currentIndex = songQueue.indexOf(foundSong);
        System.out.println("Now playing: "+currentlyPlayingSong.getName() + " by " + currentlyPlayingSong.getArtist());
    }

    public void stopSong(){
        if(currentlyPlayingSong != null){
            System.out.println("Stopping song: " + currentlyPlayingSong.getName());
            currentlyPlayingSong = null;
            songQueue.clear();
            currentIndex = -1;
        }else{
            System.out.println("No song is currently playing ");
        }    
    
    }
    public void clearQueue(){
        songQueue.clear();
        currentIndex = -1;
        System.out.println("song queue cleared.");
    }

    public void addtoQueue(Song song){
        
        songQueue.add(song);

    }

    public List<Song> getSongQueue(){
        return new LinkedList<>(songQueue);
    }
    

    public boolean isSongPlating(){
        return currentlyPlayingSong != null;
    }

    public Song nextSong(){
        if(songQueue.isEmpty()){
            throw new RuntimeException("No songs in the queue.");        
        }
        currentIndex = (currentIndex+1)%songQueue.size();
        currentlyPlayingSong = songQueue.get(currentIndex);
        System.out.println("Now playing: " + currentlyPlayingSong.getName() + " by " + currentlyPlayingSong.getArtist());
        return currentlyPlayingSong;

    }
    public Song previousSong(){
         if(songQueue.isEmpty()){
            throw new RuntimeException("No songs in the queue.");        
        }
        currentIndex = (currentIndex - 1 + songQueue.size())% songQueue.size();
        currentlyPlayingSong = songQueue.get(currentIndex);
        System.out.println("Now playing: " + currentlyPlayingSong.getName() + " by " + currentlyPlayingSong.getArtist());
        return currentlyPlayingSong;

    }

    public void executePlaySongCommand(String command) {
        if (command.equals("PLAY_SONG")) {
            Song songToPlay = songQueue.isEmpty() ? null : songQueue.get(currentIndex);
            if (songToPlay != null) {
                playSong(songToPlay.getName());
            } else {
                System.out.println("No song to play.");
            }
        }
    }

    public void playNextSong() {
        if (songQueue.isEmpty()) {
            throw new RuntimeException("No songs in the queue.");
        }
        currentIndex = (currentIndex + 1) % songQueue.size();
        currentlyPlayingSong = songQueue.get(currentIndex);
        System.out.println("Now playing: " + currentlyPlayingSong.getName() + " by " + currentlyPlayingSong.getArtist());
    }

    public void createSong(String name, String artist, String album, String genre){
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Song name cannot be null or empty");
        }
        if (artist == null || artist.trim().isEmpty()) {
            throw new IllegalArgumentException("Artist name cannot be null or empty");
        }
        if (album == null || album.trim().isEmpty()) {
            throw new IllegalArgumentException("Album name cannot be null or empty");
        }
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be null or empty");
        }

        Song newSong = new Song();
        newSong.setName(name);
        newSong.setArtist(artist);
        newSong.setAlbum(album);
        newSong.setGenre(genre);

        songRepository.addSong(newSong);
    }



    
}
