package org.testVagrant;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Manages the recently played songs for multiple users.
 */
public class RecentlyPlayedStore {
    private final int capacity;
    private final Map<String, LinkedList<Song>> userStore;

    /**
     * Constructs a new RecentlyPlayedStore with the specified capacity.
     *
     * @param capacity The maximum number of songs to store per user.
     */
    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.userStore = new HashMap<>();
    }

    /**
     * Adds a song to the user's recently played list.
     * If the song is already in the list, it removes the old occurrence and adds it to the front.
     * If the list exceeds the capacity, it removes the least recently played song.
     *
     * @param userId The ID of the user.
     * @param song The song to be added.
     */
    public void addSong(String userId, Song song) {
        userStore.putIfAbsent(userId, new LinkedList<>());

        LinkedList<Song> songs = userStore.get(userId);

        songs.remove(song);
        songs.addFirst(song);

        if (songs.size() > capacity) {
            songs.removeLast();
        }
    }

    /**
     * Gets the list of recently played songs for a user.
     *
     * @param userId The ID of the user.
     * @return A list of recently played songs.
     */
    public List<Song> getRecentlyPlayed(String userId) {
        return userStore.getOrDefault(userId, new LinkedList<>());
    }

    public static void main(String[] args) {
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);

        Song song1 = new Song("1", "S1");
        Song song2 = new Song("2", "S2");
        Song song3 = new Song("3", "S3");
        Song song4 = new Song("4", "S4");

        String userId = "user1";

        store.addSong(userId, song1);
        store.addSong(userId, song2);
        store.addSong(userId, song3);

        System.out.println(store.getRecentlyPlayed(userId));  // Output: [S3, S2, S1]

        store.addSong(userId, song4);
        System.out.println(store.getRecentlyPlayed(userId));  // Output: [S4, S3, S2]

        store.addSong(userId, song2);
        System.out.println(store.getRecentlyPlayed(userId));  // Output: [S2, S4, S3]

        store.addSong(userId, song1);
        System.out.println(store.getRecentlyPlayed(userId));  // Output: [S1, S2, S4]
    }
}
