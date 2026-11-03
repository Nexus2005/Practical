import java.util.Scanner;

public class Fibonacci {

    // Non-Recursive Method
    static void fibonacciIterative(int n) {
        int a = 0, b = 1;

        System.out.println("Fibonacci Series (Non-Recursive):");

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }

    // Recursive Method
    static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacciRecursive(n - 1)
             + fibonacciRecursive(n - 2);
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Enter a positive number.");
        } else {

            fibonacciIterative(n);

            System.out.println("\nFibonacci Series (Recursive):");

            for (int i = 0; i < n; i++) {
                System.out.print(fibonacciRecursive(i) + " ");
            }
        }

        sc.close();
    }
}


/*
Enter the number of terms: 7

Fibonacci Series (Non-Recursive):
0 1 1 2 3 5 8

Fibonacci Series (Recursive):
0 1 1 2 3 5 8
*/


/*javac Fibonacci.java
java Fibonacci



Fibonacci Series – Theory
The Fibonacci Series is a sequence of numbers in which each number is the sum of the previous two numbers. It starts with 0 and 1.

Example: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...

Formula:
\[
F(n) = F(n-1) + F(n-2)
\]

Base conditions:
- F(0) = 0
- F(1) = 1

Methods Used
1. Non-Recursive Method (Iterative):
- Uses a for loop to generate Fibonacci numbers.
- Stores the previous two numbers in variables.
- Adds them to calculate the next number.
- Updates the variables in each iteration.

2. Recursive Method:
- Uses a function that calls itself.
- Calculates the sum of the previous two Fibonacci numbers.
- Uses base conditions to stop recursive calls.

Time and Space Complexity

Method	   Time Complexity	Space Complexity
Non-Recursive	O(n)  |          O(1)
Recursive	    O(2ⁿ) |          O(n)
'''*/