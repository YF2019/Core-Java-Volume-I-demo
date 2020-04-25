package stackTrace;

import java.util.*;

/**
 * A program that displays a trace feature of a recursive method call.
 * @version 7.1.1 2020-4-25
 * @author yefan_jiang
 */
public class StackTraceTest
{
    /**
     * Computes the factorical of a number
     * @param n a non-negative integer
     * @return n! = 1 * 2 * ... * n
     */
    public static int factorical(int n)
    {
        System.out.println("factorical(" + n + "):");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement f : frames)
        {
            System.out.println(f);
        }
        int r;
        if (n <= 1)
            r = 1;
        else
            r = n * factorical(n - 1);
        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = in.nextInt();
        factorical(n);
    }
}