import java.util.Arrays;
import java.util.Scanner;

public class LotteryDrawing {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("How many numbers do you need to draw?");
        int k = in.nextInt();
        
        System.out.print("What is the highest number you can draw?");
        int n = in.nextInt();

        // fill an array with 1 2 ...n
        int[] numbers = new int[n];
        for(int i = 0; i < numbers.length; i++)
        {
            numbers[i] = i + 1;
        }

        // draw k numbers and put them into a second array
        int[] result = new int[k];
        for(int i = 0; i < result.length; i++)
        {
            // make a random index between 0 and n-1
            int r = (int)(Math.random() * n); //random'range is [0,1)

            // pick the element into the random location
            result[i] = numbers[r];

            //move the last element into the random location
            numbers[r] = numbers[n - 1];
            n--;
        }

        // print the sort result
        Arrays.sort(result);
        System.out.println("Bet the following combination. It will make you rich!(DO NOT MAKE DREAM ^-^)");
        for(int j : result)
        {
            System.out.println(j);
        }
        


    }

}