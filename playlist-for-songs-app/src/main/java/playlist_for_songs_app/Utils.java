package playlist_for_songs_app;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class Utils {

    private boolean forward = true;
    private ListIterator<Song> listIterator;

    void play(List<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        this.listIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("Now playing " + listIterator.next());
            printMenu();
        }
        while (!quit) {
            System.out.print("Your choice: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    playNextSong();
                    break;
                case 2:
                    playPreviousSong();
                    break;
                case 3:
                    replayTheCurrentSong();
                    break;
                case 4:
                    listSongsInThePlaylist(playlist);
                    break;
                case 5:
                    deleteCurrentSongFromPlaylist(playlist);
                    break;
                case 6:
                    printMenu();
                    break;
            }
        }
        scanner.close();
    }

    private void deleteCurrentSongFromPlaylist(List<Song> playlist) {
        if (playlist.size() > 0) {
            try {
                listIterator.remove();
                if (listIterator.hasNext()) {
                    System.out.println("Now replaying " + listIterator.next());
                    forward = true;
                } else if (listIterator.hasPrevious()) {
                    System.out.println("Now replaying " + listIterator.previous());
                    forward = false;
                }
            } catch (IllegalStateException e) {
                System.out.println("The playlist is empty.");
            }
        } else {
            System.out.println("The playlist is empty.");
        }
    }

    private void replayTheCurrentSong() {
        if (forward) {
            if (listIterator.hasPrevious()) {
                System.out.println("Now replaying " + listIterator.previous());
                forward = false;
            } else {
                System.out.println("We are at the start of the list");
            }
        } else {
            if (listIterator.hasNext()) {
                System.out.println("Now replaying " + listIterator.next());
                forward = true;
            } else {
                System.out.println("We are at the end of the list");
                forward = false;
            }
        }
    }

    private void playPreviousSong() {
        if (forward) {
            if (listIterator.hasPrevious()) {
                listIterator.previous();
            }
            forward = false;
        }
        if (listIterator.hasPrevious()) {
            System.out.println("Now playing " + listIterator.previous());
            forward = false;
        } else {
            System.out.println("We have reached the beginning of the playlist");
            forward = true;
        }
    }

    private void playNextSong() {
        if (!forward) {
            if (listIterator.hasNext()) {
                listIterator.next();
            }
            forward = true;
        }
        if (listIterator.hasNext()) {
            System.out.println("Now playing " + listIterator.next());
            forward = true;
        } else {
            System.out.println("We have reached the end of the playlist");
            forward = false;
        }
    }

    private void listSongsInThePlaylist(List<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("========================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("========================");
    }

    private void printMenu() {
        System.out.println("Available actions:\n" +
                "0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - delete current song from playlist\n" +
                "6 - print available actions."
        );
    }
}
