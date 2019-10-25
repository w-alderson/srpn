/**
 * Defines the properties and behaviour of Calculation.
 */

import java.util.InputMismatchException;

public class Calculation{

    private int firstPop;
    private int secondPop;
    private Stack myStack;
    private TestInput test;
    private int temp;


    /**
     * Constructor method. Sets field values for Calculation.
     * Creates new objects for Stack and TestInput.
     */
    public Calculation()
    {
        myStack = new Stack(23);
        test = new TestInput();
    }

    /**
     * Prints the top value of the stack.
     */
    public void equals(){
        try{
            System.out.println(myStack.peek());
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.err.println("Stack empty.");

        }
    }

    /**
     * Calls the myStack object to push to the stack.
     * @param : Integer which is to be pushed to the stack.
     */
    public void pushCalc(int intToPush){
        myStack.push(intToPush);
    }

    /**
     * Calls the myStack object to display every item in the stack.
     */
    public void displayCalc(){
        myStack.displayStack();
    }


    /**
     * Calls the myStack object to pop the top two elements of stack and add them together
     * with a catch for saturation and underflows.
     */
    public void addition(){
        try{
            firstPop = myStack.pop();
            secondPop = myStack.pop();
            Math.addExact(firstPop, secondPop);
            myStack.push(firstPop+secondPop);
        }
        catch(ArithmeticException e)
        {
            myStack.push(2147483647);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.err.println("Stack underflow.");
            myStack.resetStack();
            myStack.push(firstPop);

        }
    }

    /**
     * Calls the myStack object to pop the top two elements of stack and subtract them
     * with a catch for saturation and underflows.
     */
    public void subtract(){
        try{
            firstPop = myStack.pop();
            secondPop = myStack.pop();
            int temp = Math.subtractExact(secondPop,firstPop);
            myStack.push(secondPop - firstPop);
        }
        catch(ArithmeticException e)
        {
            myStack.push(-2147483648);
        }
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.err.println("Stack underflow.");
			myStack.resetStack();
			myStack.push(firstPop);
		}
    }

    /**
     * Calls the myStack object to pop the top two elements of stack and divide them
     * with a catch for arithmetic exceptions, saturation and underflows.
     */
    public void divide(){
        try{
            firstPop = myStack.pop();
            secondPop = myStack.pop();
            myStack.push(secondPop/firstPop);
        }
        catch(ArithmeticException e)
        {
            System.err.println("Divide by 0.");
            myStack.push(secondPop);
            myStack.push(firstPop);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.err.println("Stack underflow.");
            myStack.resetStack();
            myStack.push(firstPop);
        }

    }

    /**
     * Calls the myStack object to pop the top two elements of stack and add them together
     * with a catch for saturation and underflows.
     */
    public void multiply(){
        try{
            firstPop = myStack.pop();
            secondPop = myStack.pop();
            myStack.push(firstPop*secondPop);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.err.println("Stack underflow.");
            myStack.resetStack();
            myStack.push(firstPop);
        }
    }

    /**
     * Calls the myStack object to pop the top two elements of stack and calculates secondPop^firstPop
     * with a catch for negative powers, saturation and underflows.
     */
    public void power(){
        try{
            firstPop = myStack.pop();
            secondPop = myStack.pop();
            if(firstPop < 0)
            {
                System.out.println("Negative power.");
                myStack.push(secondPop);
                myStack.push(firstPop);
            }
            else{
                myStack.push((int)Math.pow(secondPop,firstPop));
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.err.println("Stack underflow.");
            myStack.resetStack();
            myStack.push(firstPop);
        }
        catch(InputMismatchException e)
        {
            myStack.push(firstPop);
        }
    }

    /**
     * Calls the myStack object to pop the top two elements of stack and finds the remainder
     * with a catch for saturation and underflows and an exit for 1 0%.
     */
    public void remainder(){
        try{
            firstPop = myStack.pop();
            secondPop = myStack.pop();
            if(firstPop == 0 && secondPop == 1){
                System.err.println("Floating point exception");
                System.exit(0);
            }
            else{
                myStack.push(secondPop%firstPop);
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            myStack.resetStack();
            myStack.push(firstPop);
        }

    }


}