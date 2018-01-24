/**
 * I hereby certify that this collective work is my own and none 
 * of it is the work of any other person or entity
 * 
 * @author    Sergio Roman
 * ID:        3331168
 * Signature: SR
 */

import java.io.FileWriter; //import to continue writing to a file
import java.io.IOException; //import to throw exceptions
import java.io.PrintWriter; //import to write to a file

/**
 * This class computes the fibonacci numbers with a fast recursive sequence
 * @author Sergio Roman
 */
public class FastRecursiveFib
{

    private static long fibArray[];//array to store prior values
    private static String outFile = ""; //stores the output file name
    
    /**
     * This method calculates and prints a list of fibonacci numbers into an
     * outputfile based on the amount of numbers given by the user. 
     * @param num
     * @throws IOException 
     */
    public static void recursive(int num) throws IOException
    {   
        //variable declaration and initialization
        long startTime = 0;
        long endTime = 0;
        long totalTime = 0;
        long fib = 0;
        int count = 0;

        FileWriter file = new FileWriter(outFile, true);
        PrintWriter writer = new PrintWriter(file);

        int number = num;
        
        //sets the array size to the amount of numbers
        fibArray = new long[number];

        writer.println();
        writer.println();
        writer.println("Recursive Sequence: ");
        writer.println();
        
        startTime = System.currentTimeMillis();//start time
        for (int i = 1; i <= number; i++)
        {
            fib = fibNumber(i);
            writer.print(fib + "\t");

            count++;
            if (count == 5)//adds a line after 5 computed numbers
            {
                writer.println();
                count = 0;
            }
        }
        endTime = System.currentTimeMillis();//end time
        
        totalTime = endTime - startTime; //total time

        writer.println();
        writer.println("Total time:  " + totalTime + " milliseconds");
        writer.close();

    }
    
    
    /**
     * This method is used to calculate the fibonacci numbers with a integer
     * parameter that is the position in the sequence. The calculated fibonacci
     * number is then returned.
     * @param num
     * @return 
     */
    public static long fibNumber(int num)
    {   
        if (fibArray[num - 1] > 0)
        {
            return fibArray[num - 1];
        }
        // checks values less than 2 and returns 1
        if (num <= 2)
        {
            fibArray[num - 1] = 1;
            return 1;
        } 
        else
        {   //the fibonacci number is itself added to its previous number
            fibArray[num - 1] = fibNumber(num - 1) + fibNumber(num - 2);
            
            return fibArray[num - 1];
        }

    }
    
    /**
     * This method gets the name of the output file using the String parameter
     * file.
     * @param file 
     */
    public static void getOutFile(String file)
    {
        outFile = file;
    }
}
