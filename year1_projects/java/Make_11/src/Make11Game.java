import java.util.ArrayList;
import java.util.Scanner;

public class Make11Game {
    private Deck deck;
    private ArrayList<Card> playerHand;
    private int totalScore;
    private int roundCount;
    private HighScoreTable highScoreTable;
    private Replay replay;

    public Make11Game() {
        this.deck = new Deck();
        this.playerHand = new ArrayList<>();
        this.totalScore = 0;
        this.roundCount = 0;
        this.highScoreTable = new HighScoreTable("highscores.txt");
        this.replay = new Replay();

        // Deal initial 5 cards to the player
        for (int i = 0; i < 5; i++) {
            playerHand.add(deck.deal());
        }
    }

    public void playRound() {
        roundCount++;
        System.out.println("Round " + roundCount + " | Current Score: " + totalScore);

        // Display high scores after each round
        highScoreTable.displayHighScores();

        // Check if the deck is empty
        if (deck.isEmpty()) {
            System.out.println("The deck is empty. Game over.");
            displayTotalScore();
            handleHighScore();
            displayReplay(); // Display replay after the game ends
            return;  // Exit the method if the deck is empty
        }

        // Deal a card from the deck for the computer
        Card computerCard = deck.deal();
        System.out.println("Computer's card: " + computerCard);

        // Display player's hand
        System.out.println("Your hand:");
        for (int i = 0; i < playerHand.size(); i++) {
            System.out.println(i + 1 + ": " + playerHand.get(i));
        }

        // Get user input for card selection with validation
        int selectedCardIndex = -1;
        do {
            selectedCardIndex = getValidInput("Select a card to Make 11 (enter the corresponding number): ");
        } while (selectedCardIndex < 1 || selectedCardIndex > playerHand.size());

        // Check if Make 11 is achieved
        if (isMake11(playerHand.get(selectedCardIndex - 1), computerCard)) {
            System.out.println("Make 11! You scored 1 point.");

            // Opt to play picture cards from the hand and replace them
            if (optToPlayPictureCards()) {
                replacePictureCards();
            } else {
                // Replace player's card with a new one from the deck
                playerHand.set(selectedCardIndex - 1, deck.deal());
            }

            totalScore++;
        } else {
            // Check if a card of the same suit can be played
            if (playerHand.get(selectedCardIndex - 1).getSuit().equals(computerCard.getSuit())) {
                System.out.println("Same suit! The game continues, but no point is scored.");
                playerHand.set(selectedCardIndex - 1, deck.deal());
            } else {
                System.out.println("You cannot Make 11 or play a card of the same suit. Game over.");
                displayTotalScore();
                handleHighScore(); // Move the high score handling here
                displayReplay();   // Display replay after the game ends
                System.exit(0);
            }
        }

        // Add information about the current round to the replay
        replay.addRoundInfo(new RoundInfo(new ArrayList<>(playerHand), computerCard,
                playerHand.get(selectedCardIndex - 1), totalScore));
    }

    private void replacePictureCards() {
        // Replace picture cards in the hand with new cards from the deck
        for (int i = 0; i < playerHand.size(); i++) {
            String rank = playerHand.get(i).getRank();
            if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
                playerHand.set(i, deck.deal());
            }
        }
    }

    private void displayTotalScore() {
        System.out.println("Total Score: " + totalScore);
    }

    private void handleHighScore() {
        // Get user input for name if a new high score is achieved
        if (highScoreTable.isNewHighScore(totalScore)) {
            Scanner nameScanner = new Scanner(System.in);
            System.out.print("Congratulations! You achieved a high score. Enter your name: ");
            String playerName = nameScanner.nextLine();
            highScoreTable.addHighScore(playerName, totalScore);
        }
    }

    private int getValidInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // consume invalid input
            }
        }

        return input;
    }

    private boolean isMake11(Card playerCard, Card computerCard) {
        int playerRank = getPlayerRankValue(playerCard);
        int computerRank = getPlayerRankValue(computerCard);
        return (playerRank + computerRank) == 11;
    }

    private boolean optToPlayPictureCards() {
        Scanner scanner = new Scanner(System.in);
        boolean validResponse = false;
        String response = "";

        while (!validResponse) {
            System.out.print("Do you want to play picture cards as well? (yes/no): ");
            response = scanner.next().toLowerCase();

            if (response.equals("yes") || response.equals("no")) {
                validResponse = true;
            } else {
                System.out.println("Error: Please enter 'yes' or 'no'.");
            }
        }

        return response.equals("yes");
    }

    private int getPlayerRankValue(Card card) {
        String rank = card.getRank();
        if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
            return 10;
        } else if (rank.equals("Ace")) {
            return 1;
        } else {
            return Integer.parseInt(rank);
        }
    }

    public void displayReplay() {
        replay.displayReplay();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Make 11!");

        Make11Game game = new Make11Game();

        // Continue playing rounds until the player decides to stop
        boolean continuePlaying = true;
        Scanner scanner = new Scanner(System.in);

        do {
            game.playRound();

            // Check if the player wants to continue
            boolean validResponse = false;
            while (!validResponse) {
                System.out.print("Do you want to play another round? (yes/no): ");
                String response = scanner.next().toLowerCase();
                if (response.equals("yes")) {
                    validResponse = true;
                } else if (response.equals("no")) {
                    validResponse = true;
                    continuePlaying = false;
                } else {
                    System.out.println("Error: Please enter 'yes' or 'no'.");
                }
            }

        } while (continuePlaying);

        game.handleHighScore(); // Move the high score handling outside the loop
        game.displayReplay();   // Display replay after the player decides to stop playing

        System.out.println("Thanks for playing!");
    }
}
