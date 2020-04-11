import java.util.Scanner;

public class Retirement {

    public static void main(final String[] args) {
        // read input
        final Scanner in = new Scanner(System.in);

        System.out.print("How much money do you need to retire?");
        final double goal = in.nextDouble();

        System.out.print("How much money will you contribute every year?");
        final double payment = in.nextDouble();

        System.out.print("Interest rate in %:");
        final double interestrate = in.nextDouble();

        double balance = 0;
        int year = 0;

        // update account balance while goal isnot reached
        while (balance < goal) {
            // add this year's payment and interest
            balance += payment;
            final double interest = balance * interestrate / 100;
            balance += interest;
            year++;
        }

        System.out.printf("You can retire in %d years",year);
    }

}