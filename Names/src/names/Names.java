
package names;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Sergio Roman
 */
public class Names {
    
    //This method promps the user for a file to use and grabs each String in the file and stores them into two array 
    public static void getNames (ArrayList<String> fn, ArrayList<String> ln) throws IOException{
        
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the name of the input file");
        String in = kb.next();
        
        File iFile = new File(in);
        Scanner inp = new Scanner(iFile);
        
        while(inp.hasNext()){
                fn.add(inp.next());
                ln.add(inp.next());
        }
    }
    
    //This method capitalizes the first letter and puts each subsequent letter in lowercase
    public static void capitalize(ArrayList<String>names){
        String n = "";
        for(int i = 0; i<names.size(); i++){
            String cap = names.get(i);
            cap = cap.substring(0,1).toUpperCase() + cap.substring(1, cap.length()).toLowerCase();
            names.set(i, cap);
            
        }
        
    }
    
    //This method displays a given arraylist
    public static void display(ArrayList<String>names)throws IOException{
        
        for(int i = 0; i<names.size(); i++){
            System.out.println(names.get(i));
        }
        
    }
    
    //This method promps the user for an output file and stores a given arraylist in that file
    public static void writeToFile (ArrayList<String> names)throws IOException { 
        
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the name of the output file");
        String out = kb.next();
        PrintWriter oFile = new PrintWriter(out);
        
        for(int i = 0; i < names.size(); i++){
            oFile.println(names.get(i));
        }
        oFile.close();
        
    }
    
    //This method finds the position of a given string in a given arraylist
    public static int find(String s, ArrayList<String>a){
        int j = 0;
        for(int i = 0; i < a.size(); i++){
            if(s.equals(a.get(i))){
                j = a.indexOf(s);
            }
        }        
        return j;
    }
    
    //This method counts the amount of duplicates in the list
    public static int count(String s, ArrayList<String>b){
        int count =0;
        for(int i = 0; i < b.size(); i++){
                if(s.equals(b.get(i))){
                    count++;
                }
            }
        
        
        
        return count;
    }
    
    //This method removes duplicate names as well as reprints the list along with the count of the duplicates
    public static void remove(ArrayList<String> n){
        
        for(int i = 0; i < n.size(); i++){
            int count = count(n.get(i), n);
            for(int j = i + 1; j < n.size(); j++){
                if(n.get(i).equals(n.get(j))){
                    n.remove(i);
                    j--;
                }
            }
            if(n.get(i).length() < 17){
                System.out.printf("%-13s%d\n", n.get(i),count );
            }
            else
            System.out.printf("%-25s%d\n", n.get(i),count );
        }
        
    }
    //This method sorts each list in alphabetical order
    public static void sort(ArrayList<String> n) {
        //b.compareTo(a) > 0
        //a.compareTo(b) < 0
        for(int i = 0; i < n.size(); i++)
            for(int j = i + 1; j < n.size(); j++){
                int comp = n.get(i).compareTo(n.get(j));
                if(comp> 0){
                String set = n.get(i);
                n.set(i, n.get(j));
                n.set(j, set);
                }
            }
    }
    
    public static void main(String[] args)throws IOException  {
        
        // two array list that store the first name "fn" , and last name "ln" 
       ArrayList<String>fn = new ArrayList<>();
       ArrayList<String>ln = new ArrayList<>();
       
       //ArrayList com will eventually store the contents of fn and ln combined
       ArrayList<String>com = new ArrayList<>();
        
        //Calls method getNames to store the names on the file into the teo array lists
        getNames(fn,ln);
        
        //Calls method capitalize for the two array lists
        capitalize(fn);
        capitalize(ln);
        
        //This for loop combines the two seperate lists into one
        for(int i = 0; i < fn.size(); i++){
            String combined = String.format("%-13s%s", ln.get(i) + ",", fn.get(i));
            com.add(i,combined);
        }
        
        sort(com);
        System.out.println("\n******All Names******");
        display(com);
        System.out.println("\n******First Name Count******");
        sort(fn);
        remove(fn);
        System.out.println("\n******Last Name Count******");
        sort(ln);
        remove(ln);
        System.out.println("\n******All Names Count******");
        remove(com);
        System.out.println("\n******All Unique Names******");
        display(com);
        System.out.println("\n");
        writeToFile(com);
    }
    
}
