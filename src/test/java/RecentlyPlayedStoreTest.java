import static org.junit.jupiter.api.Assertions.*;

import org.testVagrant.RecentlyPlayedStore;
import org.testVagrant.Song;
import org.testng.annotations.Test;
import java.util.List;

public class RecentlyPlayedStoreTest {

    @Test
    public void testRecentlyPlayedStore() {
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);

        Song song1 = new Song("1", "S1");
        Song song2 = new Song("2", "S2");
        Song song3 = new Song("3", "S3");
        Song song4 = new Song("4", "S4");

        String userId = "user1";

        store.addSong(userId, song1);
        store.addSong(userId, song2);
        store.addSong(userId, song3);

        List<Song> recentlyPlayed = store.getRecentlyPlayed(userId);
        assertEquals(3, recentlyPlayed.size());
        assertEquals("S3", recentlyPlayed.get(0).getTitle());
        assertEquals("S2", recentlyPlayed.get(1).getTitle());
        assertEquals("S1", recentlyPlayed.get(2).getTitle());

        store.addSong(userId, song4);
        recentlyPlayed = store.getRecentlyPlayed(userId);
        assertEquals(3, recentlyPlayed.size());
        assertEquals("S4", recentlyPlayed.get(0).getTitle());
        assertEquals("S3", recentlyPlayed.get(1).getTitle());
        assertEquals("S2", recentlyPlayed.get(2).getTitle());

        store.addSong(userId, song2);
        recentlyPlayed = store.getRecentlyPlayed(userId);
        assertEquals(3, recentlyPlayed.size());
        assertEquals("S2", recentlyPlayed.get(0).getTitle());
        assertEquals("S4", recentlyPlayed.get(1).getTitle());
        assertEquals("S3", recentlyPlayed.get(2).getTitle());

        store.addSong(userId, song1);
        recentlyPlayed = store.getRecentlyPlayed(userId);
        assertEquals(3, recentlyPlayed.size());
        assertEquals("S1", recentlyPlayed.get(0).getTitle());
        assertEquals("S2", recentlyPlayed.get(1).getTitle());
        assertEquals("S4", recentlyPlayed.get(2).getTitle());
    }
}
