package playlist_for_songs_app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static List<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Utils utils = new Utils();

        Album album = new Album("First Album", "First Artist");
        album.addSong("TitleA1S1", 2.34);
        album.addSong("TitleA1S2", 1.43);
        album.addSong("TitleA1S3", 3.24);
        album.addSong("TitleA1S4", 2.54);
        album.addSong("TitleA1S5", 4.03);
        album.addSong("TitleA1S6", 1.56);
        albums.add(album);

        album = new Album("Second Album", "Second Artist");
        album.addSong("TitleA2S1", 4.34);
        album.addSong("TitleA2S2", 4.43);
        album.addSong("TitleA2S3", 2.24);
        album.addSong("TitleA2S4", 1.54);
        album.addSong("TitleA2S5", 3.03);
        album.addSong("TitleA2S6", 2.56);
        albums.add(album);

        List<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist("TitleA1S4", playlist);
        albums.get(0).addToPlaylist("TitleA1S2", playlist);
        albums.get(0).addToPlaylist("TitleA1S14", playlist); // Dose not exist
        albums.get(0).addToPlaylist(6, playlist);
        albums.get(1).addToPlaylist(6, playlist);
        albums.get(1).addToPlaylist(3, playlist);
        albums.get(1).addToPlaylist(2, playlist);
        albums.get(1).addToPlaylist(24, playlist); // There is no such track

        utils.play(playlist);
    }
}
