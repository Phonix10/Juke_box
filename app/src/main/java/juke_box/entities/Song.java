package juke_box.entities;

public class Song {

    private int songId;
    private String songName;
    private String artist;
    private String album;
    private String genre;
    private int playCount;
    private static int songCount = 1;

    // constructor
    public Song(String songName, String artist, String album, String genre) {
        this.songName = songName;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.playCount = 0;
        setId();
    }
    // constructor for testing

    // setters and getters
    public int getId() {
        return songId;
    }
    public void setId() {
        this.songId = songCount;    
        songCount++;
    }

    public String getSongName() {
        return songName;
    }  
    public void setName(String songName) {
        this.songName = songName;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getPlayCount() {
        return playCount;
    }
    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    // toString method
    @Override
    public String toString() {
        return "Song{" +
                "id=" + songId +
                ", songName='" + songName + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", genre='" + genre + '\'' +
                ", playCount=" + playCount +
                '}';
    }
    
}
