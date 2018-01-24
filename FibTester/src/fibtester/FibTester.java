/**
 * I hereby certify that this collective work is my own and none 
 * of it is the work of any other person or entity
 * 
 * @author    Sergio Roman
 * ID:        3331168
 * Signature: SR
 */

import java.io.FileWriter; //import to continue writing to a file
import java.io.IOException; //import for exception handling
import java.io.PrintWriter; //import to write to a file

/**
 * This class is used to test the fast recursive fibonacci sequence and print
 * both the recursive and iteration loops, in table format, to a file.
 *
 * @author Sergio Roman
 */
public class FibTester
{

    private static String outFile = ""; //Stores the name of the output file

    /**
     * This method takes an integer parameter and determines what the next
     * fibonacci number is going to be.
     *
     * @param num
     * @return
     */
    public static long iterativeFibNum(int num)
    {
        //Variable declaration and initialization
        long oldNum = 0;
        long newNum = 0;
        long currentNum = 0;

        /*
         begins at 3 because the first three values of the the fibonacci sequence 
         are already accounted for.
         */
        int loop = 3;

        if (num <= 2)
        {
            return 1;
        } 
        else
        {
            oldNum = 1;
            newNum = 1;
            currentNum = 1;

            //The for loop calculates the next fibonacci number in the sequence
            for (loop = 3; loop <= num; loop++)
            {
                currentNum = oldNum + newNum;
                oldNum = newNum;
                newNum = currentNum;
            }
            return newNum;
        }
    }

    /**
     * This method computes the list of fibonacci numbers and prints them to a
     * designated file in table format.
     *
     * @param num
     * @return
     * @throws IOException
     */
    public static void iterative(int num) throws IOException
    {
        //Variable declaration and initialization
        long startTime = 0;
        long fibNumber = 0;
        long endTime = 0;
        long totalTime = 0;
        int position = 1;
        int count = 0;

        FileWriter file = new FileWriter(outFile);
        PrintWriter writer = new PrintWriter(file);

        writer.println("Iterative Sequence: ");
        writer.println();

        startTime = System.currentTimeMillis(); //starts timer

        for (position = 1; position <= num; position++)
        {
            fibNumber = iterativeFibNum(position);
            writer.print(fibNumber + "\t");

            count++;
            if (count == 5)//after 5 numbers, skips to next line
            {
                writer.println();
                count = 0;
            }
        }

        endTime = System.currentTimeMillis();//stops timer

        totalTime = endTime - startTime; //computes total time

        writer.println();
        writer.print("Total time:  " + totalTime + " milliseconds");
        writer.close();

    }

    public static void main(String[] args) throws IOException
    {
        String inFile = args[0];
        outFile = args[1];

        int num = 0;
        int count = 0;
        long[] iterative = new long[0];
        long[] recursive = new long[0];
        boolean inNotFound = true;
        boolean outNotFound = true;

        FastRecursiveFib.getOutFile(outFile);

        //checks to make sure the files are there and returns true if they arent
        inNotFound = FileExceptions.noFile(inFile);
        outNotFound = FileExceptions.noFile(outFile);

        //if files are found, then starts computation
        if (inNotFound == false && outNotFound == false)
        {
            //makes sure the input file has the appropriate data
            num = FileExceptions.readFile(inFile);

            if (num > 0)//the number of iterations has to be greater than 0
            {
                iterative(num);
                FastRecursiveFib.recursive(num);
            }
        }

    }

}
