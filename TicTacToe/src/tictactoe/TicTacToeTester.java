/**
 * I hereby certify that this collective work is my own and none 
 * of it is the work of any other person or entity
 * 
 * @author    Sergio Roman
 * ID:        3331168
 * Signature: SR
 */


import java.util.Scanner;

/**
 *
 * @author Sergio Roman
 */
public class TicTacToeTester 
{
    /**
     * This method is used to print out a prompt at the start of the program.
     * it contains instructions on how to enter the input. it does not take in 
     * any parameters nor does it return a value.
     */
    public static void prompt(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to Tic-Tac-Toe!!!");
        System.out.println("\nThis game consist of two players (player O and player X),"
                + "each player will enter coordinates to play their move!");
        System.out.println("\nFor example: (0,0) refers to the upper left corner of the board, "
                + "and (2,2) refers to the bottom right courner of the board.");
        System.out.println("\nEach player will be prompted to enter their "
                + "coordinates seperated by a line! For example, to play at "
                + "position (1,1) the player will enter it like this:\n\n1\n1");
        System.out.println("\n\nWhen you are ready to play press Enter!");
        
        input.nextLine();
    }
  
    
    public static void main(String[] args) 
    {
        //creates a tic-tac-toe object
        TicTacToe board = new TicTacToe();
        
        //creates a scanner object
        Scanner input = new Scanner(System.in);
        
        //variable declaration and initialization
        String x = " X ";
        String o = " O ";
        int row = 0;
        int row1 = 0;
        int col = 0;
        boolean checkRow = false;
        boolean checkCol = false;
        boolean checkDiagonal = false;
        boolean checkBoard = true;
        
        //calls and prints the prompt method
        prompt();
        
        /**
         * a for loop is used because we know that there are only a maximum
         * of 9 number of moves in tic-tac-toe before the game comes to a draw.
         * therefore we use a for loop not only as a loop, but also as a counter
         * to state when the game has come to a draw.
         */
        for(int i = 0; i < 10; i++)
        {   
            System.out.println("\n\nX-Player please enter your next move: ");
            
            //a while loop to ensure input is a number
            while(!input.hasNextInt())
            {
                System.out.println("\nYour first value must be a number! Please enter "
                        + "another first value followed by the second value");
                
                input.next();
                
            }
            
            row = input.nextInt();
            
            //a while loop to ensure input is a number
            while(!input.hasNextInt())
            {
                System.out.println("\nYour second value must be a number! Please "
                        + "enter a different second value");
                
                input.next();
            }
            
            col = input.nextInt();
            
            //method checkBoard is stored in variable checkBoard
            checkBoard = board.checkBoard(row, col);
            
            //a while loop to check user input using the checkBoard method
            while(checkBoard == false)
            {
                System.out.println("\nThe position you have entered is invalid, "
                        + "please try again");
                
                row = input.nextInt();
                col = input.nextInt();
                
                checkBoard = board.checkBoard(row, col);
            }
            
            //sets values into the array after all validation checks
            board.set(row,col,x);
            
            //displays the tic-tac-toe board
            board.display();
            
            //winner checks
            checkRow = board.checkRow(x);
            checkCol = board.checkCol(x);
            checkDiagonal = board.checkDiagonal(x);
            
            //if there is a winner, the loop is exited and the program closes
            if(checkRow == true || checkCol == true || checkDiagonal == true)
            {
                System.out.println("\n\nCongratulations X-Player, you won!!!\n\n");
                System.exit(0);
            }
            else
            {
                i++;
            }
            // if 9 moves are made, the game is a draw
            if(i == 9)
            {
                System.out.println("\n\nThe game has ended in a draw!\n");
                System.exit(0);
                
            }
                
            System.out.println("\n\nO-Player please enter your next move: ");
            
            //a while loop to ensure input is a number
            while(!input.hasNextInt())
            {
                System.out.println("\nYour first value must be a number! Please enter "
                        + "another first value followed by the second value");
                
                input.next();
                
            }
            
            row = input.nextInt();
            
            //a while loop to ensure input is a number
            while(!input.hasNextInt())
            {
                System.out.println("\nYour second value must be a number! Please "
                        + "enter a different second value");
                
                input.next();
            }
            
            col = input.nextInt();
            
            //method checkBoard is stored in variable checkBoard
            checkBoard = board.checkBoard(row, col);
            
            //a while loop to check user input using the checkBoard method
            while(checkBoard == false)
            {
                System.out.println("\nThat position is an invalid play, "
                        + "please try again");
                
                row = input.nextInt();
                col = input.nextInt();
                
                checkBoard = board.checkBoard(row, col);
            }
            
            //sets values into the array after all validation chekcs
            board.set(row , col , o);
            
            //displays the tic-tac-toe board
            board.display();
            
            //winner checks
            checkRow = board.checkRow(o);
            checkCol = board.checkCol(o);
            checkDiagonal = board.checkDiagonal(o);
            
            //if there is a winner the loop is exited and the program closes
            if(checkRow == true || checkCol == true || checkDiagonal == true)
            {
                System.out.println("\n\nCongratulations O-Player, you won!!!\n\n");
                System.exit(0);
            }
            
        }
        
    }
    
}
