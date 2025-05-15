package juke_box.entities;

public class Song {

    private static int idCounter = 1;
    private int songId;
    private String name;
    private String artist;
    private String album;
    private String genre;

    public Song() {
    }

    public Song(String name, String artist, String album, String genre) {
        this.songId = idCounter++;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
    }

       public int getSongId() {
        return songId;
    }
    public void setSongId(int songId) {
        this.songId = songId;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "Song [id=" + songId + "]";
        
    }

}
