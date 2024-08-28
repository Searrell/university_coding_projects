import org.junit.Test;
import static org.junit.Assert.*;

public class JunitCardDeckTest {

    @Test
    public void testCard() {
        // Test default constructor
        Card card1 = new Card();
        assertNotNull(card1.getRank());
        assertNotNull(card1.getSuit());

        // Test parameterized constructor
        Card card2 = new Card(3, 2);
        assertEquals("4", card2.getRank());
        assertEquals("Hearts", card2.getSuit());


    }

    @Test
    public void testDeck() {
        // Test Deck constructor and isEmpty method
        Deck deck = new Deck();
        assertFalse(deck.isEmpty());

        // Test deal method
        Card dealtCard = deck.deal();
        assertNotNull(dealtCard);
        assertFalse(deck.isEmpty());

        // Test toString method
        assertNotNull(deck.toString());
    }
}
