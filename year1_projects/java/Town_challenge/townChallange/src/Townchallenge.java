import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Townchallenge {

    public static void main(String[] args) throws Exception {

        String[] towns = new String[8]; // Create an array to store town names
        Random random = new Random();
        int homeScore, awayScore;
        int homes = 0, draws = 0, aways = 0;

        // Read town names from "towns.txt" and populate the array
        File townFile = new File("src/towns.txt");
        Scanner townScanner = new Scanner(townFile);

        int index = 0;
        while (townScanner.hasNextLine() && index < 8) {
            towns[index] = townScanner.nextLine();
            index++;
        }
        townScanner.close();

        // Open the output file in append mode
        FileWriter outputFile = new FileWriter("src/outputfile.txt", true);

        // Get the number of matches to show from the user
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of matches to show: ");
        int numMatchesToShow = keyboard.nextInt();

        // Ensure that the user-specified number is within bounds
        numMatchesToShow = Math.min(numMatchesToShow, towns.length / 2);

        // Write to the output file
        outputFile.write("Line 1 written to the file\n");
        outputFile.write("line 2 written to the file\n");
        outputFile.write(String.format("Homes %d Draws %d Aways %d%n", homes, draws, aways));

        for (int i = 0; i < numMatchesToShow; i++) {
            homeScore = random.nextInt(10);
            awayScore = random.nextInt(10);
            String result = String.format("%-12s %3d %-12s %3d%n", towns[i * 2], homeScore, towns[i * 2 + 1], awayScore);

            // Write the result to the output file
            outputFile.write(result);

            if (homeScore > awayScore) {
                homes++;
            } else if (homeScore < awayScore) {
                aways++;
            } else {
                draws++;
            }
        }

        outputFile.write(String.format("Homes %d Draws %d Aways %d%n", homes, draws, aways));


        System.out.printf("Homes %d, Draws %d, Aways %d%n", homes, draws, aways);

        // Close the output file
        outputFile.close();
    }
}

