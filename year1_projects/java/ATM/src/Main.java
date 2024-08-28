
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int balance = 2000, withdraw, deposit;


        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("Welcome to ATM.");
            System.out.println(" Use Num pad to navigate menu.");
            System.out.println(" ");
            System.out.println(" 1. Withdraw");
            System.out.println(" 2. Deposit");
            System.out.println(" 3. Check balance");
            System.out.println(" 4. Exit");

            // start of switch
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Enter amount you wish to withdraw.");

                    System.out.println(("£5            £10\n£20           £50\n£100          £250\n"));
                    withdraw = sc.nextInt();

                    //if statement to handle withdraw limit & amounts allowed
                    if (withdraw % 5 != 0 || withdraw > 250) {
                        System.out.println("Chose a valid option.");
                    } else if (balance < withdraw) {
                        System.out.println(" Error: not enough funds");
                                //made this useless now with implementation of withdraw limit.
                    } else {
                        balance = balance - withdraw;
                        System.out.println("Balance = " + balance);
                        System.out.println("Please collect your money and card. ");

                    }
                    System.out.println(" ");
                    break;

                case 2:
                    System.out.println("Enter Deposit amount");
                    System.out.println("Note: Cant deposit more than £1,000 in the ATM. See cashier to deposit larger sums of cash.");
                    deposit = sc.nextInt();

                    // if statement to handle deposit limit& currency accepted
                    if (deposit % 5 != 0 || deposit > 1000) {
                        System.out.println("Smallest amount able to be deposited is £5, smaller change is not accepted!.");
                    }
                    else {
                        balance = balance + deposit;

                        System.out.println("Balance amount is:" + balance);
                        System.out.println("Money successfully deposited");
                        System.out.println(" ");
                    }
                    break;

                case 3:
                    System.out.println(" Account balance is: £" + balance);
                    System.out.println(" ");
                    break;

                case 4:
                    System.exit(0);
                    System.out.println("(^.^)");
                    break;


            }

        }
    }

}