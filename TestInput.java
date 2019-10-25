/**
 * Defines the properties and behaviour of TestInput.
 */

public class TestInput{

    private int skipCount;

    /**
     * Constructor method for TestInput
     */
    public TestInput(){
    }

    /**
     * Tests to see if an character input can be converted to an integer.
     * @param : Character to test
     * @return : True if character is an integer.
     */

    public boolean isInt(char toTest){
        try {
            Integer.parseInt(Character.toString(toTest));
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    /**
     *
     * @param : Character to test.
     * @return : Returns true if character after an '-' can be converted to an integer.
     */
    public boolean possibleNegative(char toTest){
        try{
            Integer.parseInt(Character.toString(toTest));
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    /**
     *
     * @param : The integer to test.
     * @return : Returns count, how many digits are in the integer.
     */
    public int numberOfDigits(int numberToTest){
        int count = 0;
        while (numberToTest != 0){
            numberToTest = numberToTest / 10;
            count ++;
        }
        return count;
    }

    /**
     *
     * @param : The user input, The current position in the calculation.
     * @param : The current position in processCommand (in the SRPN class).
     * @return skipCount
     *          The number of positions to skip.
     */
    public int commentSkip(String stringToSkip,int position){


        for(int i = position; i < stringToSkip.length(); i++){
            if (stringToSkip.charAt(i) == '#'){
                skipCount = i;
            }
            else if(i == stringToSkip.length()-1){
                System.out.print("Unrecognised operator or operand \"#\".\n");
                skipCount = 0;
            }
        }
        return skipCount;

    }

}