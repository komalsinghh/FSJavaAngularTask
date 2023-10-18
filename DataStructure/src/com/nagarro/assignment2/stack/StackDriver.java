package com.nagarro.assignment2.stack;

import java.util.Scanner;

public class StackDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ans = ' ';
		MyStack stack = new MyStack();
		do {
			System.out.println("**********************************************");
			System.out.println("Enter 1 for Push");
			System.out.println("Enter 2 for Pop");
			System.out.println("Enter 3 to see Top Element");
			System.out.println("Enter 4 for Search");
			System.out.println("Enter 5 for Stack Size");
			System.out.println("Enter 6 to see the Center Element");
			System.out.println("Enter 7 for Sort");
			System.out.println("Enter 8 for Reverse");
			System.out.println("Enter 9 for Display using Iterator");
			System.out.println("Enter 10 for Display");
			System.out.println("**********************************************");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			try {
				switch (choice) {
				case 1:stack.push();
					
					break;

				case 2:
					stack.pop();
					break;

				case 3:
					System.out.println("The Top Element is" + stack.peek());
					break;

				case 4:
					if (stack.contains())
						System.out.println("Element is Present in Stack");
					else
						System.out.println("Stack does not contain it" );
					break;

				case 5: System.out.println("Stack Size "+stack.size());
						break;
						
				case 6:
					System.out.println("The Center Element is "+stack.center());
					break;
					
				case 7:
					System.out.println("Stack Sorted ");
					stack.sort();
					break;

				case 8:
					System.out.println("Stack After Reversing");
					stack.reverse();
					break;

				case 9:
					System.out.println("Displaying items using iterator");
					stack.myIterator();
					break;
				case 10:
					System.out.println("Items present in Stack are");
					stack.displayStack();
					break;
				default:
					System.out.println("Please enter valid choice!");
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			System.out.println("Do you want to enter any more choice (y/n)?");
			ans = sc.next().charAt(0);
		} while (ans == 'y');
		sc.close();
	}

}
