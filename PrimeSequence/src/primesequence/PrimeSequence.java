package primesequence;

/**
 * I hereby certify that this collective work is my own and none 
 * of it is the work of any other person or entity
 * 
 * @author    Sergio Roman
 * ID:        3331168
 * Signature: SR
 */


public class PrimeSequence implements Sequence
{
    /**
     * This method overrides the sequence interface and checks to see if 
     * the given parameter is a prime number or not. If it is a prime number,
     * the isPrime boolean is returned true.
     * @param primeNum
     * @return 
     */
   
    public boolean isPrime(int primeNum)
    {
        for (int i = 2; i < primeNum; i++)
        {
            if (primeNum % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
