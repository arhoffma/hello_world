import java.util.Scanner;
/**
This is to compute factorials using recursive method
**/

public class ComputeFactorial {


	// method factorial uses recursion to compute factorials
	public static long factorial(int n) {
	
		if (n==0) // Base case
			return 1;
		else
			return n*factorial(n-1); // Recursive call
				
	}
	
	// main method
	public static void main(String[] args) {
		
		// new Scanner object
		Scanner input = new Scanner(System.in);
		
		// prompt user input
		System.out.print("Enter an integer: ");
		
		// assign user input to int variable n 
		int n = input.nextInt();
		
		// print output to console
		System.out.println("Factorial of " + n + " is " + factorial(n));
		
		input.close();
		
	}


}
