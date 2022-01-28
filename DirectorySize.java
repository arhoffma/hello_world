/**
This program will prompt a user to enter a directory, calculate its size 
using a recursive method, and display it to the console.
**/

import java.io.File;
import java.util.Scanner;

public class DirectorySize {

	// method getSize 
	public static long getSize(File file) {
	
		long size = 0; // store total size of all files
		
		if (file.isDirectory()) {
			File[] files = file.listFiles(); // all files and subdirectories
			for (int i = 0; files != null && i < files.length; i++) {
				size += getSize(files[i]); // recursive call	
			}
		}
		else{
			size += file.length(); // base case
		}
		return size;
	}
	
	// main method
	public static void main(String[] args) {
		
		// prompt for user input	
		System.out.print("Enter a directory or file: ");
		
		// new Scanner object and assign user input to String directory
		String directory = new Scanner(System.in).nextLine();
		
		// print output to console
		System.out.println(getSize(new File(directory)) + " bytes");
	}


}
