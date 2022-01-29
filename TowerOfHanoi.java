/**
Tower of Hanoi is a classic recursion problem in which a specified number of disks 
of distinct sizes must be moved from one tower to another while observing the 
following rules:

1. There are n disks labeled 1, 2, 3, . . . , n and three towers labeled A, B, and C.
2. No disk can be on top of a smaller disk at any time.
3. All the disks are initially placed on tower A.
4.  Only one disk can be moved at a time and it must be the smallest disk on a tower.
**/

import java.util.Scanner;

public class TowerOfHanoi {
	
	// method moveDisks computes the next move 
	public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
	
		if (n==1) // base case, stopping condition
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
		
		else {
			// move from A to C with the assistance of B
			moveDisks(n-1, fromTower, auxTower, toTower); // recursive call
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
			// move from C to B with the assistance of A
			moveDisks(n-1, auxTower, toTower, fromTower); // recursive call
		}
	}
	
	// main method
	public static void main(String[] args) {
	
		// prompt user input
		System.out.print("Enter a number of disks: ");
		int n = new Scanner(System.in).nextInt();
		
		// print result to console
		System.out.println("The moves are: ");
		moveDisks(n, 'A', 'B', 'C');

	}
}

