/*
Author: Daniel Cronauer
Date: 11/20/2022
File: NameParserApp.java
Purpose: This will ensure that the user enters a persons name. Either First and Last.
Or First, Middle, Last. Should be able to trim whitespace. 
Update: 11/27/2022 working on git assignment
*/

import java.util.Scanner;

public class NameParserApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // prompt user to enter a string for the users name
        System.out.print("Enter a name: ");
        String name = sc.nextLine();
        System.out.println();
        
        // trim whitespace on both ends of name line
        name = name.trim();
        
        // find index of first space (this is after trim, so index will be inside the meat of the string 
        // not on the ends)
        int index1 = name.indexOf(" ");
        
        // check to see if string had a space in it, if so these separates first from last or first from 
        // middle, if index1 = -1 that means that the string had no blank space in it, so it is not in a
        // valid format, so we should let the user know.
        if(index1 == -1)
        {
            System.out.println("Name not in valid format");
        }
        // in this case we have a space somewhere in the middle of the string, next we will check if there
        // is a second space in the string. If so it means we have first, middle, last instead of just
        // first and last name. 
        else
        {
            // find index of second space if it exists, start at spot after last white space, so we 
            // dont stop on that index again
            int index2 = name.indexOf(" ",index1 +1);
            
            // if no match this time we know that name is just first and last and display appropriately
            if(index2==-1)
            {
                // first name goes from start of string to index of first space (substring excludes ending index in
                // substring method
                String firstName = name.substring(0,index1);
                // since we know there are no other spaces, the remainder of the string after the location of index1
                // is the start of the last name and should go until the end of the string. 
                String lastName = name.substring(index1 +1);
                
                //print out output
                System.out.println("First name: " + firstName);
                System.out.println("Last name: "+ lastName);
            }
            else
            {
                // if index2 is not -1 we know that there is a third section to capture
                // for the last name and index2 tells you the start of the middle name
                // however, first we need to check for a third space. If there is a third
                // that is too many and we need to raise an error
                int index3 = name.indexOf(" ",index2 + 1);
                
                //we want index 3 to be -1, if this is true we are good to print out
                // first, middle, and last name. Otherwise we need to print an error. 
                if(index3 == -1)
                {
                    //get first name start zero go to first index 
                    String firstName = name.substring(0,index1);
                    
                    // get middle name start at one element after index1 then go to
                    // index2
                    String middleName = name.substring(index1 +1,index2);
                    
                    // get last name start at one element after index 2 then to end of string
                    String lastName = name.substring(index2 +1);
                    
                    //print full name each line for itself
                    System.out.println("First name: " + firstName);
                    System.out.println("Middle name: "+ middleName);
                    System.out.println("Last name: "+ lastName);
                }
                //print out error shouldnt have 3 spaces inside the string
                else
                {
                    System.out.println("Name not in valid format.");
                }
                
            }
        }
    }
}
