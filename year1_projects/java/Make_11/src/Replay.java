import java.util.ArrayList;

public class Replay {
    private ArrayList<RoundInfo> rounds;

    public Replay() {
        this.rounds = new ArrayList<>();
    }

    public void addRoundInfo(RoundInfo roundInfo) {
        rounds.add(roundInfo);
    }

    public void displayReplay() {
        System.out.println("\nReplay:");

        for (int i = 0; i < rounds.size(); i++) {
            RoundInfo roundInfo = rounds.get(i);
            System.out.println("Round " + (i + 1) + ":");
            System.out.println("Player's Hand: " + roundInfo.getPlayerHand());
            System.out.println("Computer's Card: " + roundInfo.getComputerCard());
            System.out.println("Selected Card: " + roundInfo.getSelectedCard());
            System.out.println("Total Score: " + roundInfo.getTotalScore());
            System.out.println();
        }
    }
}
