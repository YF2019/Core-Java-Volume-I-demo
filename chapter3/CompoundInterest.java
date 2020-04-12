import java.util.Arrays;

public class CompoundInterest {
    public static void main(String args[])
    {
        final double STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;

        //set interest rate to 10 ... 15%
        double[] interestRate = new double[NRATES];
        for(int i = 0; i < interestRate.length; i++)
        {
            interestRate[i] = STARTRATE + i;
            interestRate[i] /= 100.0 ;
        }

        double[][] balance = new double[NYEARS][NRATES];

        // set initial balance to 10000
        for(int j = 0; j < balance[0].length; j++)
            balance[0][j] = 10000;
        
        // compute interest for future years
        for(int i = 1; i < balance.length; i++)
        {
            for(int j = 0; j < balance[0].length; j++)
            {
                // compute interest
                double interest = interestRate[j] * balance[i - 1][j];

                // compute this year's balance
                balance[i][j] = interest + balance[i - 1][j];
            }
        }

        // print one row of interest rates
        for(int i = 0; i < interestRate.length; i++)
        {
            System.out.printf("%9.0f%%", interestRate[i] * 100);
        }

        System.out.println();
        
        // print balance table
        for(double[] row : balance){
            for(double col : row)
                System.out.printf("%10.2f",col);
            System.out.println();
        }


        /* another way to print
        System.out.println(Arrays.deepToString(balance)); 
        */

        


        
    }

}