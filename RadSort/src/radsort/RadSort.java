/*********************************************************************
 Purpose/Description: <This program sorts an array using the Radix Sort method>
 Author’s Panther ID: <3331168>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sergio Roman
 */
public class RadSort
{

    public static void radixSort(int arr[])
    {
        int max = 0;
        int div = 1;
        int len = arr.length;
        int[] tmpArr = new int[10];

        for (int k = 0; k < 3; k++)
        {
            ArrayList<Integer>[] bucket = new ArrayList[10];

            for (int i = 0; i < 10; i++)
            {
                bucket[i] = new ArrayList();
            }

            for (int i = 0; i < arr.length; i++)
            {
                bucket[(arr[i] / div) % 10].add(arr[i]);
            }

            div *= 10;
            int in = 0;

            for (int i = 0; i < 10; i++)
            {
                for (int num : bucket[i])
                {
                    arr[in] = num;
                    in++;
                }
            }
        }

    }

    public static void main(String[] args)
    {
        int[] a = new int[10];

        Scanner in = new Scanner(System.in);
        
        System.out.println("Please enter 10 even numbers that you want to sort:");
        a[0] = in.nextInt();
        a[1] = in.nextInt();
        a[2] = in.nextInt();
        a[3] = in.nextInt();
        a[4] = in.nextInt();
        a[5] = in.nextInt();
        a[6] = in.nextInt();
        a[7] = in.nextInt();
        a[8] = in.nextInt();
        a[9] = in.nextInt();
        
        for(int i = 0; i < a.length; i++)
        {
            if((a[i] % 2)!= 0)
            {
                System.out.println("You must enter even numbers only!"
                        + " Please try again");
                System.exit(0);
            }
        }
        
        radixSort(a);
        
        System.out.println("\n\nHere is the list of numebrs sorted: \n");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }

    }

}
