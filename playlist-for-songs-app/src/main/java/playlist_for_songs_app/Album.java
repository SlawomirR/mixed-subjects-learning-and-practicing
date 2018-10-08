package playlist_for_songs_app;

import java.util.ArrayList;
import java.util.List;

class Album {

    private String albumName;
    private String artist;
    private SongList songs;

    Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;
        this.songs = new SongList();
    }

    boolean addSong(String title, double duration) {
        return this.songs.add(new Song(title, duration));
    }

    boolean addToPlaylist(int trackNumber, List<Song> playlist) {
        Song checkedSong = this.songs.findSong(trackNumber);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    boolean addToPlaylist(String title, List<Song> playlist) {
        Song checkedSong = this.songs.findSong(title);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }
}

class SongList {

    private List<Song> songs;

    SongList() {
        this.songs = new ArrayList<>();
    }

    boolean add(Song song) {
        if (songs.contains(song)) {
            return false;
        }
        this.songs.add(song);
        return true;
    }

    Song findSong(String title) {
        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    Song findSong(int trackNumber) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index < songs.size())) {
            return songs.get(index);
        }
        return null;
    }
}
