package org.testVagrant;

import java.util.Objects;

public class Song {
    private String songId;
    private String title;

    /**
     * Constructs a new Song with the specified ID and title.
     *
     * @param songId The unique identifier for the song.
     * @param title The title of the song.
     */
    public Song(String songId, String title) {
        this.songId = songId;
        this.title = title;
    }

    public Song() {
        // Default constructor
    }

    public String getSongId() {
        return songId;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(songId, song.songId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId);
    }

    @Override
    public String toString() {
        return title;
    }
}