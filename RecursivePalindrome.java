import java.util.Scanner;

/**
This program decides whether a string is a palindrome using recursion
**/

public class RecursivePalindrome {

	// method isPalindrome 
	public static boolean isPalindrome(String s) {

		return isPalindrome(s, 0, s.length()-1);

	}
	
	
	// helper method isPalindrome
	private static boolean isPalindrome(String s, int low, int high) {
	
		if (high<=low) // Base case
			return true;
		else if (s.charAt(low) != s.charAt(high)) // Base case
			return false;
		else
			return isPalindrome(s, low + 1, high -1); // Recursive call
				
	}
	
	// main method with Scanner object
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: "); // ptompt for user input
		
		String s = input.nextLine(); // assign user input to variable s
		
		// print output to console
		System.out.println("Is " + s + " a palindrome? " + isPalindrome(s));	
	
		/*
		System.out.println("Is moon an palindrome? " + isPalindrome("moon"));
		System.out.println("Is noon an palindrome? " + isPalindrome("noon"));
		System.out.println("Is a a palindrome? " + isPalindrome("a"));
		System.out.println("Is aba a palindrome? " + isPalindrome("aba"));
		System.out.println("Is ab a palindrome? " + isPalindrome("ab"));
		*/
		
		input.close(); // close input 

	}

}
