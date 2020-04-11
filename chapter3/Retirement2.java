import java.util.Scanner;

public class Retirement2 {

    public static void main(final String[] args) {
        // read input
        final Scanner in = new Scanner(System.in);

        System.out.print("How much money will you contribute every year?");
        final double payment = in.nextDouble();

        System.out.print("Interest rate in %:");
        final double interestrate = in.nextDouble();

        double balance = 0;
        int year = 0;

        String input;

        // update account balance while user isnot ready to retire
        do{
            // add this year's payment and interest
            balance += payment;
            final double interest = balance * interestrate / 100;
            balance += interest;
            year++;
            
            //print current balance
            System.out.printf("After %d year, you balance is %,.2f%n",year,balance);

            //ask if ready to retire and get input
            System.out.print("Are you ready to retire? (Y/N)");
            input = in.next();
        }
        while(input.equals("N"));

    }

}