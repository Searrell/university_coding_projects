import java.util.Random;
public class Townchallenge {

    public static void main(String[] args){

        String[] towns = { "Coleraine", "Belfast", "Banbridge", "Ballymoney",
                "Nerwy", "Enniskillen", "Portadown", "Bangor"};
        Random random = new Random();
        int homeScore, awayScore;
        int homes = 0, draws = 0, aways = 0;

         for (int i = 0; i <4; i++){
            homeScore = random.nextInt(10);
            awayScore = random.nextInt(10);
            System.out.println(towns[i*2] + " " + homeScore + " "
                    + towns[1*2 +1] + " " + awayScore);

            if (homeScore > awayScore) {
                homes++;
            } else if (homeScore < awayScore) {
                aways++;
            } else {
                draws++;
            }


        }

         System.out.println("Homes " + homes + ", Draws " + draws + ",Aways " + aways);

    }


}
