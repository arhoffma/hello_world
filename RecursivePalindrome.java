import java.util.Scanner;

/**
This program decides whether a string is a palindrome using recursion
**/

public class RecursivePalindrome {

	// method isPalindrome 
	public static boolean isPalindrome(String str) {

		return isPalindrome(str, 0, str.length()-1);

	}
	
	
	// helper method isPalindrome
	private static boolean isPalindrome(String str, int low, int high) {
	
		if (high<=low) // Base case
			return true;
		else if (str.charAt(low) != str.charAt(high)) // Base case
			return false;
		else
			return isPalindrome(str, low + 1, high -1); // Recursive call
				
	}
	
	// main method with scanner object
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: "); // ptompt for user input
		
		String str = input.nextLine(); // assign user input to variable s
		
		// print output to console
		System.out.println("Is " + str + " a palindrome? " + isPalindrome(str));	
	
		/*
		system.out.println("Is moon an palindrome? " + isPalindrome("moon"));
		system.out.println("Is noon an palindrome? " + isPalindrome("noon"));
		system.out.println("Is a a palindrome? " + isPalindrome("a"));
		system.out.println("Is aba a palindrome? " + isPalindrome("aba"));
		system.out.println("Is ab a palindrome? " + isPalindrome("ab"));
		*/
		
		input.close(); // close input 

	}

}
