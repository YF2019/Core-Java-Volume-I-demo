import java.util.Scanner;

public class InputTest {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);

        //get first input
        System.out.println("What is your name?");
        String name = in.nextLine();

        //get second input
        System.out.println("How old are you?");
        int age = in.nextInt();

        //System.out.println("Hello, " + name + ". Next year, you will be " + (age + 1) );
        System.out.printf("Hello, %s. Next year you will be %d.",name,age);
    }
}
