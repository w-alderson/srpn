/**
 * Defines the properties and behaviour of Stack.
 */

public class Stack{

    private int top;
    private int array[];
    private int maxSize;
    private int displayCount;

    /**
     * Constructor method. Gives previously initilised variables values to create an empty stack.
     * @param : The maximum size of the desired stack
     */

    public Stack(int n){

        maxSize = n;
        array = new int[maxSize];
        top = 0;
    }

    /**
     * Pushes an integer value to the stack and readjusts top for the next command.
     * @param : Integer value to be pushed to the stack.
     */
    public void push (int n){

        if(top<maxSize){
            array[top] = n;
            top++;
        }
        else{
            System.err.println("Stack overflow.");
        }

    }

    /**
     * Pops the top value from the stack and re-adjusts top for the next command.
     * @return :array[top], the top value of the stack.
     */

    public int pop(){

        top--;
        return array[top];
    }

    /**
     * Displays the top value of the stack whilst keeping the value of top the same.
     * @return : array[top}, the top value of the stack.
     */

    public int peek(){
        return array[top-1];
    }

    /**
     * Prints every value of the stack in order from top = 0 to top = top.
     */
    public void displayStack(){

        displayCount = 0;
        while (displayCount < top){
            System.out.println(array[displayCount]);
            displayCount++;
        }
    }

    /**
     * Sets top to 0 so next command over-writes the stack.
     */
    public void resetStack(){

        top = 0;
    }
}