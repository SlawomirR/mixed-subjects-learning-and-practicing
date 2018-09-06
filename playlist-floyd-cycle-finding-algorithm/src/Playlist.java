public class Playlist {

    public static class Song {

        private String name;
        private Song nextSong;

        public Song(String name) {
            this.name = name;
        }

        void setNextSong(Song nextSong) {
            this.nextSong = nextSong;
        }

        boolean isRepeatingPlaylist() {
            Song fast;
            Song slow;
            if (Song.this.nextSong == null) {
                return false;
            }
            slow = fast = Song.this.nextSong;
            while (true) {
                slow = slow.nextSong;
                if (fast.nextSong != null) {
                    fast = fast.nextSong.nextSong;
                } else {
                    return false;
                }
                if (slow == null || fast == null) {
                    return false;
                }
                if (slow == fast) {
                    return true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}

// links to web sites that help:
// https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html
// https://stackoverflow.com/questions/2663115/how-to-detect-a-loop-in-a-linked-list