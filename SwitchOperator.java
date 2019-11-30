package day1;

import java.util.Scanner;

public class SwitchOperator {

	/*
	 * Goal: Perform calculation based on the user input operations
	 * 
	 * inputs: 2,3 and "add"
	 * output: added value: 5
	 * 
	 * Shortcuts:
	 * 1) Print : type: syso, followed by: ctrl + space + enter
	 * 2) To create a Switch case: type 'switch', followed by: ctrl + space + down arrow + enter
	 *   
	 * What are my learnings from this code?
	 * 1)Learnt Switch case logic
	 * 2)
	 * 3) 
	 * 
	 */	
	
	public static void main(String[] args) {
		
		// Declare 2 integer numbers
		int a,b,c;
		a=2;b=3;
		String s1;
		// Declare a String variable with input as operations (Tip:
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the operation to be performed");
		String s= input.next();
		// Initiate switch case for operations
		switch (s) {
		case "add":
			c=a+b;
			System.out.println("Addition operation performed: " + c);
			break;

		case "sub":
			c=a-b;
			System.out.println("Subtraction operation performed: " + c);
			break;
			
		case "multiply":
			c=a*b;
			System.out.println("Multiplication operation performed: " + c);
			break;
			
		default:
			System.out.println("Invalid operation performed");
			break;
		}
		
			// Within switch, include as case for add operation
		
		
			// Within switch, include as case for sub operation
		
		
			// Within switch, include as case for mul operation
		
		
			// Within switch, include as case for div operation
		
		
			// Within switch, include 'default' to handle other operations
		
		
		//end of switch case
		
	}

}
