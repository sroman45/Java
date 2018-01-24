/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package change;

import javax.swing.JOptionPane;

/**
 * @author Andres Archila
 * @author Sergio Roman
 */
public class Change {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String pa = JOptionPane.showInputDialog("What is the purchase amount?");
        double purchaseAmount;
        
         //Improper user inputs
        
        if (pa == null) {
            JOptionPane.showMessageDialog(null, "You must enter a valid integer", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        if (pa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You must enter a valid integer", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
        if(!Character.isDigit(pa.charAt(0))){
            JOptionPane.showMessageDialog(null, "You must enter a valid integer", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
        int p1 = pa.indexOf('.');
        int p2 = pa.indexOf('.', p1+1);
        if(p2>=1){
            JOptionPane.showMessageDialog(null, "You have too many decimal points in the value you entered", "ERROR!",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
        if (p1 != -1 && pa.substring(p1+1).length()>2){
            JOptionPane.showMessageDialog(null, "You have entered an invalid monetary amount", 
                    "Too Many Decimal Places", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
        //Record users input as double
        purchaseAmount = Double.parseDouble(pa);
        
        //tax calculation + new total
        double tax;
        
        tax = (purchaseAmount * 0.07);
        
        double newPA = purchaseAmount + tax;
        //Displays a message box with the tax and new total, as well as prompt the user to enter an amount to a with
        String pay = JOptionPane.showInputDialog(String.format("Here is the calculated tax along with the new total:\n\n"
                + "Sales Tax: $%.2f\nTotal Due:$%.2f\n\nNow please enter the amount you will be paying with", tax,newPA));
        
        //Improper payments
        if (pay == null) {
            JOptionPane.showMessageDialog(null, "You must enter a valid integer", "ERROR!",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        if (pay.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You must enter a valid integer", "ERROR!",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
        if(!Character.isDigit(pay.charAt(0))){
            JOptionPane.showMessageDialog(null, "You must enter a valid integer", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
         p1 = pay.indexOf('.');
        p2 = pay.indexOf('.', p1+1);
        if(p2>=1){
            JOptionPane.showMessageDialog(null, "You have too many decimal points in the value you entered", "ERROR!",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
        if (p1 != -1 && pay.substring(p1+1).length()>2){
            JOptionPane.showMessageDialog(null, "You have entered an invalid monetary amount", 
                    "Too Many Decimal Places", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
        
        double payAmount;
        payAmount = Double.parseDouble(pay);
        
        //Runs this method if the users payment amount is less than that of the purchase amount
        if(payAmount < newPA){
            System.out.println("\n\nYou have not paid enough");
            System.exit(0);
        }
        
        double change;
        change = payAmount - newPA;
        double billChange = payAmount - newPA;
        billChange = billChange+0.005;
        //System.out.printf("\nChange: $%.2f\n", change);
        
        
        
        
        int twenty;
        int ten;
        int five;
        int one;
        int quarter;
        int dime;
        int nickel;
        int penny;
        
        twenty = (int)((billChange*100)/2000);
        billChange = ((billChange)%20);
        ten = (int)((billChange*100)/1000);
        billChange = ((billChange)%10);
        five = (int)((billChange*100)/500);
        billChange = ((billChange)%5);
        one = (int)((billChange*100)/100);
        billChange = ((billChange)%1);
        quarter = (int)((billChange*100)/25);
        billChange = ((billChange)%0.25);
        dime = (int)((billChange*100)/10);
        billChange = ((billChange)%0.10);
        nickel = (int)((billChange*100)/5);
        billChange = ((billChange)%0.05);
        penny = (int)((billChange*100)/1);
        
        String twenties = " Twenty dollar bills\n";
        String tens = " Ten dollar bills\n";
        String fives = " Five dollar bills\n";
        String ones = " One dollar bills\n";
        String quarters = " Quarters\n";
        String dimes = " Dimes\n";
        String nickels = " Nickels\n";
        String pennies = " Pennies\n";

        String twentyString = Integer.toString(twenty);
        String tenString = Integer.toString(ten);
        String fiveString = Integer.toString(five);
        String oneString = Integer.toString(one);
        String quarterString = Integer.toString(quarter);
        String dimeString = Integer.toString(dime);
        String nickelString = Integer.toString(nickel);
        String pennyString = Integer.toString(penny);

        if (twenty == 1) {

            twenties = " Twenty dollar bill\n";
        } else if (twenty == 0) {

            twenties = "";
            twentyString = "";

        }

        if (ten == 1) {

            tens = " Ten dollar bill\n";
        } else if (ten == 0) {

            tens = "";
            tenString = "";

        }
        if (five == 1) {

            fives = " Five dollar bill\n";
        } else if (five == 0) {

            fives = "";
            fiveString = "";

        }
        if (one == 1) {

            ones = " Dollar bill\n";
        } else if (one == 0) {

            ones = "";
            oneString = "";

        }
        if (quarter == 1) {

            quarters = " Quarter\n";

        } else if (quarter == 0) {

            quarters = "";
            quarterString = "";

        }
        if (dime == 1) {

            dimes = " Dime\n";
        } else if (dime == 0) {

            dimes = "";
            dimeString = "";

        }
        if (nickel == 1) {

            nickels = " Nickel\n";
        } else if (nickel == 0) {

            nickels = "";
            nickelString = "";

        }
        if (penny == 1) {

            pennies = " Penny";
        } else if (penny == 0) {

            pennies = "";
            pennyString = "";

        }

        JOptionPane.showMessageDialog(null, String.format("Your change is: $%.2f\n\n", change)+twentyString + twenties + tenString + tens
                + fiveString + fives + oneString + ones
                + quarterString + quarters + dimeString + dimes
                + nickelString + nickels + pennyString + pennies, 
                "Change", JOptionPane.INFORMATION_MESSAGE);
   
    }
        
        
        // TODO code application logic here
    }
    

