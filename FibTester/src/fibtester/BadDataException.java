
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Roman
 */
public class BadDataException extends IOException
{
    public BadDataException(String message)
    {
        System.out.println("\n\n" + message + "\n\n");
    }
}
