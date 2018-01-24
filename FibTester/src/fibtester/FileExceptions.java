
/**
 * I hereby certify that this collective work is my own and none of it is the
 * work of any other person or entity
 *
 * @author Sergio Roman ID: 3331168 Signature: SR
 */

import java.io.File; //import to create a file object
import java.io.IOException; //import to throw and catch exceptions
import java.util.Scanner; //import to read input files

/**
 * This class is used to handle exceptions and input errors
 *
 * @author Sergio Roman
 */
public class FileExceptions
{

    private static int number = 0;

    /**
     * This method takes a String parameter to make sure that the name of the
     * file given actually exists. If the file does not exist, the boolean that
     * is returned is true. If the file is found, the boolean returns false.
     *
     * @param files
     * @return
     */
    public static boolean noFile(String files)
    {
        boolean notFound = false;

        try
        {
            File file = new File(files);

            //throws the exception if there is no file
            Scanner in = new Scanner(file);
        } 
        catch (IOException exception)//catches the exception
        {
            System.out.println("\n\nThe " + files + " file was not found, please "
                    + "make sure the file is in the proper directory");
            notFound = true;
        }

        return notFound;
    }

    /**
     * This method reads a file with the scanner parameter and checks to make
     * sure that the input file contains the appropriate data.
     *
     * @param input
     */
    private static void readData(Scanner input)
    {
        int check = 0;// used to check the value on the file

        if (!input.hasNextInt()) //this checks for only integers in the file
        {
            System.out.println("\n\nThe file must contain an integer value,");
        } 
        else
        {
            check = input.nextInt();
        }
        if (check <= 0)// the value cannot be less than 0
        {
            System.out.println("\n\nThe value contained in the file must be greater"
                    + " than 0, please correct your file and try again.");
        } 
        else
        {
            number = check;
        }

    }

    /**
     * This method takes a file and reads it and returns the integer value
     * contained within the file. The String parameter is used to carry in the
     * name of the input file and reads it and then closes it after it obtains
     * the data.
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static int readFile(String fileName) throws IOException
    {
        File input = new File(fileName);
        Scanner in = new Scanner(input);
        try
        {
            readData(in); // calls the readData method to check the file.
            return number;
        } 
        finally
        {
            in.close();
        }
    }

}
