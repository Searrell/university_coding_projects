import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class JunitHighScoreTest {

    @Test
    public void testHighScoreEntry() {
        HighScoreEntry entry1 = new HighScoreEntry("Player1", 100);
        HighScoreEntry entry2 = new HighScoreEntry("Player2", 150);

        assertEquals("Player1", entry1.getPlayerName());
        assertEquals(100, entry1.getScore());

        assertTrue(entry2.compareTo(entry1) > 0);
        assertFalse(entry1.compareTo(entry2) > 0);

        String entryString = entry1.toString();
        assertTrue(entryString.contains("Player1") && entryString.contains("100"));
    }


}
