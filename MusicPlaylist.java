import java.util.*;

class Song {
    String title;

    Song(String title) {
        this.title = title;
    }

    public String toString() {
        return title;
    }
}

class Playlist {
    private LinkedList<Song> songs = new LinkedList<>();

    public void addSong(Song song) {
        songs.addLast(song);
    }

    public void removeSong(String title) {
        songs.removeIf(s -> s.title.equalsIgnoreCase(title));
    }

    public void playNext() {
        if (!songs.isEmpty()) {
            System.out.println("Now playing: " + songs.pollFirst());
        } else {
            System.out.println("No songs in the playlist.");
        }
    }

    public void showPlaylist() {
        System.out.println("Current Playlist: " + songs);
    }
}

class MediaPlayer {
    public void playMedia() {
        System.out.println("Playing media...");
    }
}

class MusicPlayer extends MediaPlayer {
    Playlist playlist = new Playlist();

    public void addSong(String title) {
        playlist.addSong(new Song(title));
    }

    public void removeSong(String title) {
        playlist.removeSong(title);
    }

    public void playNext() {
        playlist.playNext();
    }

    public void showPlaylist() {
        playlist.showPlaylist();
    }
}

public class MusicPlaylist {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.addSong("Shape of You");
        player.addSong("Blinding Lights");
        player.addSong("Levitating");
        player.showPlaylist();
        player.playNext();
        player.playNext();
        player.removeSong("Levitating");
        player.showPlaylist();
    }
}
