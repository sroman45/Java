/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import java.util.Scanner;

/**
 *
 * @author Sergio Roman
 * 
 */
public class Calender {

    //Method that creates a Calender
    
    public static void calender(int month, int year) {

        System.out.println("\n\n      " + getMonthName(month) + "  " + year);

        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int startDay = getStartDay(month, year);
        int weekDay = startDay;
        int days = getDaysIn(month, year);
        
        //loop used for the spacing between month days
        
        for (int i = 1; i < startDay; i++) {
            System.out.print("    ");
        }
        
        //loop used for the format of the calender
        
        for (int i = 1; i <= days; i++) {
            System.out.format("%3d ", i);
            weekDay = weekDay + 1;
            if (weekDay > 7) {
                System.out.println();
                weekDay = 1;
            }
        }
        
        System.out.println("\n\n");
    }

    //Converts the months into integer values
    
    public static int getMonthNumber(String s) {
        int monthNum = 0;
        if (s.equalsIgnoreCase("jan")) {
            monthNum = 1;
        }
        if (s.equalsIgnoreCase("feb")) {
            monthNum = 2;
        }
        if (s.equalsIgnoreCase("mar")) {
            monthNum = 3;
        }
        if (s.equalsIgnoreCase("apr")) {
            monthNum = 4;
        }
        if (s.equalsIgnoreCase("may")) {
            monthNum = 5;
        }
        if (s.equalsIgnoreCase("jun")) {
            monthNum = 6;
        }
        if (s.equalsIgnoreCase("jul")) {
            monthNum = 7;
        }
        if (s.equalsIgnoreCase("aug")) {
            monthNum = 8;
        }
        if (s.equalsIgnoreCase("sep")) {
            monthNum = 9;
        }
        if (s.equalsIgnoreCase("oct")) {
            monthNum = 10;
        }
        if (s.equalsIgnoreCase("nov")) {
            monthNum = 11;
        }
        if (s.equalsIgnoreCase("dec")) {
            monthNum = 12;
        }

        return monthNum;
    }

    //Leap Year Method
    
    public static boolean isLeapYear(int year) {
        boolean ly = false;
        for (int leap = 1904; leap < 2100; leap = leap + 4) {
            if (year == leap) {
                ly = true;
            }
        }

        return ly;

    }

    //Converts the integer value of a given month to its proper name
    
    public static String getMonthName(int month) {

        String monthName = "";

        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }
        return monthName;
    }

    //Returns the number of days in a given month (including leap years)
    
    public static int getDaysIn(int month, int year) {
        
        int days;

        if (isLeapYear(year) == true && month == 2) {
            days = 29;
        } else {
            days = 28;
        }

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;

        }

        return days;
    }

    //Returns The first day of a given month of a given year
    
    public static int getStartDay(int month, int year) {
        if (month == 1) {
            month = 13;
            year = year - 1;
        }
        if (month == 2) {
            month = 14;
            year = year - 1;
        }
        int firstDay = (1 + 2 * month + ((3 * (month + 1)) / 5) + year + (year / 4) - (year / 100) + (year / 400) + 2);
        firstDay = firstDay % 7;
        if (firstDay % 7 == 0) {
            firstDay = 7;
        }
        return firstDay;
    }
    
    //Checks if the user enters a valid month
    
    public static int checkMonth(String c){
        int checkMon = 0;
        
        if (c.equalsIgnoreCase("jan")) {
            checkMon = 1;
        }
        if (c.equalsIgnoreCase("feb")) {
            checkMon = 1;
        }
        if (c.equalsIgnoreCase("mar")) {
            checkMon = 1;
        }
        if (c.equalsIgnoreCase("apr")) {
            checkMon = 1;
        }
        if (c.equalsIgnoreCase("may")) {
            checkMon = 1;
        }
        if (c.equalsIgnoreCase("jun")) {
            checkMon = 1;
        }
        if (c.equalsIgnoreCase("jul")) {
            checkMon = 1;
        }
        if (c.equalsIgnoreCase("aug")) {
            checkMon = 1;
        }
        if (c.equalsIgnoreCase("sep")) {
            checkMon = 1;
        }
        if (c.equalsIgnoreCase("oct")) {
            checkMon = 1;
        }
        if (c.equalsIgnoreCase("nov")) {
            checkMon = 1;
        }
        if (c.equalsIgnoreCase("dec")) {
            checkMon = 1;
        }
        
        return checkMon;
    }

    public static void main(String[] args) {
        
        //Variable declaration
        
        int monthNum = 0;
        int year = 0;
        String reBoot;
        int j = 0;
        String checkInt;
        
        //The while loop controls how many times the program restarts
        
        while (j < 3) {
            Scanner ip = new Scanner(System.in);
           for (int i = 0; i < 4;) {
                System.out.println("Use the format (ex: JAN 2015) to enter a date between the years 1900-2099\n"
                        + "I will then display the calender for the given date. ");
                
                
                
                //Grabs user input
                
                String line = ip.nextLine();
                
                //used to determine spaces in the users input
                
                int p1 = line.indexOf(" ");
                int p2 = line.indexOf(" ", p1+1);
                
                
                //wrong entries for no spaces or too many spaces
                
                if (p2>=1 || line.charAt(3) != ' '){
                    System.out.println("\nYou must enter a valid date! Try again\n\n");
                    i++;
                    if (i == 3) {
                        System.out.println("\nYou have entered too many invalid entries!");
                        System.exit(0);
                    }
                }
                
                //splits the user input only if the above statement is false
                
                if(p2<1 && line.charAt(3) == ' '){
                String[] split = line.split(" ");
                String yearString;
                String month;
                
                
                yearString = split[1];
                month = split[0];
                
                
                monthNum = getMonthNumber(month);
                year = Integer.parseInt(yearString);
                checkInt = Integer.toString(year);
                int check = checkMonth(month);
                
                //more Invalid user entries
                
                if (year < 1900 || year > 2099 || check == 0) {
                    System.out.println("\nYou must enter a valid date! Try again\n\n");
                    i++;
                    if (i == 3) {
                        System.out.println("\nYou have entered too many invalid entries!");
                        System.exit(0);
                    }
                } else {
                    i = 4;
                   
                }
                }
            }
            
            //Prints the calender
            
            calender(monthNum, year);
            
            // Asks the user if they want to enter another date therefore printing another calender
            
            System.out.println("Do you want to enter another date? (Y/N) : ");
            reBoot = ip.next();
            if (reBoot.equalsIgnoreCase("y") || reBoot.equalsIgnoreCase("yes")) {
                System.out.println("");
                j++;
                if(j == 3){
                    
                }
            } if(reBoot.equalsIgnoreCase("n") || reBoot.equalsIgnoreCase("no")){
                System.out.println("\nYou have printed all your requested calenders!\nThank you for running me!");
                j = 3;
            }
        
        }
    }

}
