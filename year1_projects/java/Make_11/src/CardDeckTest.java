public class CardDeckTest {
    public static void main(String[] args) {
        // Test Card class
        Card card1 = new Card();
        Card card2 = new Card(3, 2);

        System.out.println("Card 1: " + card1.toString());
        System.out.println("Card 2: " + card2.toString());

        System.out.println("Is Card 1 bigger than Card 2? " + card1.isBiggerThan(card2));

        // Test Deck class
        Deck deck = new Deck();

        System.out.println("\nInitial Deck:");
        System.out.println(deck.toString());

        System.out.println("Dealing a card: " + deck.deal().toString());
        System.out.println("Is the deck empty? " + deck.isEmpty());

        System.out.println("\nDeck after dealing a card:");
        System.out.println(deck.toString());
    }
}
