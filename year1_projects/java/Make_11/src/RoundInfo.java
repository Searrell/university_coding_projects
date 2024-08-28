import java.util.ArrayList;

public class RoundInfo {
    private ArrayList<Card> playerHand;
    private Card computerCard;
    private Card selectedCard;
    private int totalScore;

    public RoundInfo(ArrayList<Card> playerHand, Card computerCard, Card selectedCard, int totalScore) {
        this.playerHand = new ArrayList<>(playerHand);
        this.computerCard = computerCard;
        this.selectedCard = selectedCard;
        this.totalScore = totalScore;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public Card getComputerCard() {
        return computerCard;
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
