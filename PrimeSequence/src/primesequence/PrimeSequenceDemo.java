package primesequence;

/**
 * I hereby certify that this collective work is my own and none 
 * of it is the work of any other person or entity
 * 
 * @author    Sergio Roman
 * ID:        3331168
 * Signature: SR
 */


public class PrimeSequenceDemo
{

    public static void main(String[] args)
    {
        //variable declaration and initialization
        int counter = 0; // keeps track of the row length
        int reps = 0; // counts the number of prime numbers
        int primeNum = 2; // starts at two because 2 is the first prime number
        
        //creates a prime sequence object with the sequence interface
        PrimeSequence seq = new PrimeSequence();
        /**
         * a while loop that repeats 100 times to get the first 100 
         * prime numbers.
         */
        while(reps < 100)
        {   
            //if true, prints out the prime number
            if (seq.isPrime(primeNum))
            {
                System.out.printf("   %3d", primeNum);
                counter++;
                reps++;
            }
            //starts a new line after 10 prime numbers
            if (counter == 10)
            {
                System.out.println("");
                counter = 0;
            }
            primeNum++;
        }
    }
}
