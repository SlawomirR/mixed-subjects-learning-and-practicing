package playlist_for_songs_app;

public final class Song {

    private final String title;
    private final double duration;

    Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
