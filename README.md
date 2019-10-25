# SRPN

SRPN is made up of 4 classes, SRPN (includes main function), Claculation, Stack and TestInput.

## Command Line Prompts

The program is an adaptation of a Reverse Polish Calculator. The first digits entered should be numbers (digits) followed by the operations you wish to carry out. The supported operations are as followed:

> '+' for addition
> '-' for subtraction
> '\\' for division
> '*' for multiplication
> '^' for power
> '%' for remainder

Other useful commands include:

> 'd' for displaying the top value of the stack
> '#' for adding comments
> '=' for displaying the answer

## SRPN.java

Handles user input / console output and creates instances of TestInput.java, Calculation.java and Random.java.

## Calculation.java

Handles pushing and popping from the stack as required based on user prompts.

## Stack.java

Maintains a stack to handle nested calculations.

## TestInput.java

Tests input digits to check they positive integers or accepted characters listed above.
