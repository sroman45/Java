/**
 * I hereby certify that this collective work is my own and none 
 * of it is the work of any other person or entity
 * 
 * @author    Sergio Roman
 * ID:        3331168
 * Signature: SR
 */




public class TicTacToe 
{
    
    
    private String[][] board = new String[0][0];
    
    /**
     * A Tic-Tac-Toe constructor that creates a Tic-Tac-Toe board object using 
     * a 2-Dimensional array. A Tic-Tac-Toe board consist of 9 playable spots
     * which is why the max number of columns and rows are set to 3 each (3x3 = 9)
     * After constructing the array, each position in the array is then set to
     * three spaces ("   ") for visual purposes in the display() method. The object
     * takes no parameters nor does it return a value.
     */
    public TicTacToe()
    {
        final int MAX_ROWS = 3;
        final int MAX_COL = 3;
        
        board = new String[MAX_ROWS][MAX_COL];
        
        for(int i = 0; i < 3; i++){
            
            board[0][i] = "   ";
            board[1][i] = "   ";
            board[2][i] = "   ";
        }
            
    }
    
    
    
    /**
     * This method is used to display a visual Tic-Tac-Toe board. The method
     * displays each variable in the array in its corresponding position. The 
     * numbers fluctuate from 0 - 2 because there are only 3 positions in each
     * array. This method takes no parameters nor does it return a value.
     */
    public void display()
    {
        
        System.out.println("    " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    " + "-----------");
        System.out.println("    " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    " + "-----------");
        System.out.println("    " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
    
    
    /**
     * This method is used to set a value into the array depending on the parameter
     * row and column. It then takes a String to place that String in the given
     * position. This method does not return any values
     * @param row
     * @param col
     * @param letter 
     */
    public void set(int row, int col, String letter)
    {
        
        board[row][col] = letter;
        
    }
    
    
    /**
     * This method is used to check each row in the array to see if there is a 
     * winner. The method takes in the letter (either x or o) and checks each
     * row to see if there are 3 of a kind. The numbers rotate between 0 - 2 
     * because there are only 3 spaces in each dimension of the array. This method
     * returns a boolean true if there is in fact a winner
     * @param letter
     * @return 
     */
    public boolean checkRow(String letter)
    {
        
        boolean check = false;
        
        if( board[0][0] == letter && board[0][1] == letter && board[0][2] == letter
                || board[1][0] == letter && board[1][1] == letter && board[1][2] == letter
                || board[2][0] == letter && board[2][1] == letter && board[2][2] == letter
                )
        {
            
            check = true;
        }
        
        return check;
    }
    
    
    
    /**
     * This method is used to check each column in the array to see if there is a 
     * winner. The method takes in the letter (either x or o) and checks each
     * column to see if there are 3 of a kind. The numbers rotate between 0 - 2 
     * because there are only 3 spaces in each dimension of the array. This method
     * returns a boolean true if there is in fact a winner
     * @param letter
     * @return 
     */
    public boolean checkCol(String letter)
    {
        
        boolean check = false;
        
        if( board[0][0] == letter && board[1][0] == letter && board[2][0] == letter
                || board[0][1] == letter && board[1][1] == letter && board[2][1] == letter
                || board[0][2] == letter && board[1][2] == letter && board[2][2] == letter
                )
        {
            
            check = true;
        }
        
        return check;
    }
    
    
    
    /**This method is used to check each diagonal in the array to see if there is a 
     * winner. The method takes in the letter (either x or o) and checks each
     * diagonal to see if there are 3 of a kind. The numbers rotate between 0 - 2 
     * because there are only 3 spaces in each dimension of the array. This method
     * returns a boolean true if there is in fact a winner
     */
    public boolean checkDiagonal(String letter)
    {
        
        boolean check = false;
        
        if(board[0][0] == letter && board[1][1] == letter && board[2][2] == letter
                || board[0][2] == letter && board[1][1] == letter && board[2][0] == letter)
        {
            
            check = true;
            
        }
        
        return check;
    }
    
    
    /**
     * This method takes in the parameters row and col to check and see if the 
     * input of the user is within the bounds of the array; that is, it is 
     * between 0 - 2. It also then checks to see if the input of the users 
     * desire has a value already at that position. if both arguments are satisfied,
     * the boolean check is returned true, otherwise it will return false
     * @param row
     * @param col
     * @return 
     */
    public boolean checkBoard(int row, int col){
        
        boolean check = true;
        
        if(row < 0 || row > 2 || col < 0 || col > 2)
        {
            check = false;
        }
        else if(board[row][col] != "   ")
        {
            check = false;
        }
        
        return check;
        
    }
    
   
}
