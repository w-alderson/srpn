/**
 * SRPN.java to accept and process user input (contains the main function).
 * Adapted from SRPN.java resource from moodle.
 */

import java.io.*;
import java.util.Scanner;

public class SRPN {

    private TestInput myTest;
    private Calculation myCalc;
    private Random myRandom;

    /**
     * Constructor. Sets the field values for SRPN.
     * Creates new objects for TestInput, Calculation and Random.
     */
    private SRPN() {

        myTest = new TestInput();
        myCalc = new Calculation();
        myRandom = new Random();

    }


    /**
     * Takes the input and first scans it for numbers. These numbers are pushed to the object
     * myStack. It then searches the string character by character to check for potential operators,
     * otherwise it prints a default statement.
     *
     * @param : The string inputted by the user in main.
     */
    private void processCommand(String s) {

        int nextNumber;
        int counter = 0;
        Scanner intScanner = new Scanner(s).useDelimiter("\\D+");

        while (counter < s.length()) {

            //Special case for inputs such as 05
            if (s.charAt(counter) == '0') {
                try {
                    if (!(myTest.isInt(s.charAt(counter + 1)))) {
                        myCalc.pushCalc(0);
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    myCalc.pushCalc(0);
                }

            //Deals with negative numbers or subtraction
            } else if (s.charAt(counter) == '-') {
                try {
                    if (myTest.possibleNegative(s.charAt(counter + 1))) {
                        nextNumber = intScanner.nextInt();
                        nextNumber *= -1;
                        myCalc.pushCalc(nextNumber);
                        counter += myTest.numberOfDigits(nextNumber);
                    }
                }
                catch (StringIndexOutOfBoundsException e) {
                    myCalc.subtract();
                }

             //Pushes numbers to myStack
            }else if (myTest.isInt(s.charAt(counter))) {

                nextNumber = intScanner.nextInt();
                myCalc.pushCalc(nextNumber);
                counter += myTest.numberOfDigits(nextNumber) - 1;

            //Recognises operators and special characters
            } else {
                if (s.charAt(counter) == '=') {
                    myCalc.equals();
                } else if (s.charAt(counter) == '+') {
                    myCalc.addition();
                } else if (s.charAt(counter) == '/') {
                    myCalc.divide();
                } else if (s.charAt(counter) == '*') {
                    myCalc.multiply();
                } else if (s.charAt(counter) == '%') {
                    myCalc.remainder();
                } else if (s.charAt(counter) == '^') {
                    myCalc.power();
                } else if (s.charAt(counter) == 'd') {
                    myCalc.displayCalc();
                } else if (s.charAt(counter) == '#') {
                    counter += myTest.commentSkip(s, counter);
                } else if (s.charAt(counter) == 'r') {
                    myCalc.pushCalc(myRandom.rand());
                } else if (s.charAt(counter) != ' ') {
                    System.out.print("Unrecognised operator or operand \"" + s.charAt(counter) + "\".\n");
                }

            }
            counter++;
        }
    }

    /**
     *
     * Main function to accept user input and call processCommand
     * @param :Not utilised in this case.
     */

    public static void main(String[] args) {

        String command;
        SRPN srpn = new SRPN();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            //Keep on accepting input from the command-line
            while(true) {
                command = reader.readLine();
                //Close on an End-of-file (EOF) (Ctrl-D on the terminal)
                if(command == null)
                {
                    //Exit code 0 for a graceful exit
                    System.exit(0);
                }
                else{
                    //Otherwise, (attempt to) process the character
                    srpn.processCommand(command);
                }
            }
        }
        catch(IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
