
/**
 * I hereby certify that this collective work is my own and none of it is the
 * work of any other person or entity.
 *
 *
 *
 * @author Sergio Roman
 */
package pie;
/**
 * The Pie class computes the actual value of pie using the Leibniz formula
 * then compares how accurate the system is (using up to 6 significant digits)
 * to Java's library version of PI (Math.PI) using a while loop, then displays
 * the number of iterations it took to reach an accurate calculation using
 * Leibniz's formula compared to the Math.PI of Java and the computed value at
 * that number of iterations, also displays the standard Math.PI of Java.
*/
public class Pie {

    public static void main(String[] args) {

        int odd = 1; //denominator variable, all odd starting at 1
        double pi = 0.0; //pi's sum variable
        int counter = 0; //counter for how many times the loops iterates 
        boolean run = true; //allows the program to run until correct output
        double currentTerm = 0.0; //current term of pi
        int term = 1; //term starting point;

        //takes Java library's PI and converts 
        //into string form with 6 significant figures
        String sixSig = String.format("%.8s", Double.toString(Math.PI));

        while (run) {

            //if term is even then the current term is negative
            //else then it is positive
            if (term % 2 == 0) {
                currentTerm = (double) -4 / odd;
            } else {
                currentTerm = (double) 4 / odd;
            }
            
            odd = odd + 2; //increases the denominators by 2
            pi = pi + currentTerm; //keeps adding the current term
            
            
            //takes the computed PI and converts 
            //into string form with 6 significant figures
            String computedPiSix = String.format("%.8s", Double.toString(pi));

            term++; //increases by 1 to calculate the next term
            counter++; //increase by 1 every time the loop iterates

            //outputs how many times the loop iterated when the computed pi
            //to the sixth degree matched the library's sixth significant degree
            if (sixSig.equals(computedPiSix)) {

                System.out.println("Number of loop iterations: " + counter);
                run = false; //when matched run is false to terminate the loop
            }

        }

        // outputs the answer
        System.out.println("Java library expected value for pie: " + Math.PI);
        System.out.println("Computed Pi to the 6th significant digit: " + pi);

    }
}
