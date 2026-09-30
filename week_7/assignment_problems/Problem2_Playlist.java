import java.util.Arrays;

class Playlist {
    private final String[] songs;
    private int songCount;

    Playlist(int maximumSongs) {
        if (maximumSongs < 0) {
            throw new IllegalArgumentException("Maximum songs cannot be negative.");
        }
        songs = new String[maximumSongs];
    }

    boolean addSong(String song) {
        if (song == null || song.trim().isEmpty() || songCount == songs.length) {
            return false;
        }
        songs[songCount++] = song;
        return true;
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    int getSongCount() {
        return songCount;
    }
}

public class Problem2_Playlist {
    public static void main(String[] args) {
        Playlist playlist = new Playlist(10);
        playlist.addSong("Song A");
        playlist.addSong("Song B");

        String[] copy = playlist.getSongs();
        copy[0] = "Changed outside";

        System.out.println("Songs: " + Arrays.toString(playlist.getSongs()));
        System.out.println("Song count: " + playlist.getSongCount());
    }
}