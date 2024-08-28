import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TidyTown {
    private ArrayList<String> volunteerNames;

    public TidyTown() {
        volunteerNames = new ArrayList<>();
    }

    public void enterVolunteerNames() {
        Scanner scanner = new Scanner(System.in);
        String inputName;

        System.out.println("Enter volunteer names in the format 'Surname, Firstname'.");
        System.out.println("Enter 'xxx' to finish.");

        while (true) {
            System.out.print("Enter a name: ");
            inputName = scanner.nextLine();

            if (inputName.equals("xxx")) {
                break;  // Exit the loop if 'xxx' is entered
            }

            if (isValidNameFormat(inputName)) {
                volunteerNames.add(inputName);
                Collections.sort(volunteerNames);  // Sort the names alphabetically
            } else {
                System.out.println("Invalid name format. Please enter names in the format 'Surname, Firstname'.");
            }
        }
    }

    public void displaySortedNames() {
        System.out.println("Sorted list of volunteer names:");
        for (String name : volunteerNames) {
            System.out.println(name);
        }
    }

    private boolean isValidNameFormat(String name) {
        // Check if the name is in the format "Surname, Firstname"
        return name.matches("^[A-Z][a-z]+, [A-Z][a-z]+$");
    }

    public static void main(String[] args) {
        TidyTown tidyTown = new TidyTown();
        tidyTown.enterVolunteerNames();
        tidyTown.displaySortedNames();
    }
}
