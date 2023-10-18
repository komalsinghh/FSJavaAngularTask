package com.nagarro.assignment2.queue;

import java.util.Scanner;

public class QueueDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ans = ' ';
		MyQueue queue = new MyQueue();
		do {
			System.out.println("**********************************************");
			System.out.println("Enter 1 for Push");
			System.out.println("Enter 2 for Pop");
			System.out.println("Enter 3 to see Top Element");
			System.out.println("Enter 4 for Search");
			System.out.println("Enter 5 for queue Size");
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
				case 1:queue.enqueue();
					
					break;

				case 2:
					queue.dequeue();
					break;

				case 3:
					System.out.println("The Top Element is" + queue.peek());
					break;

				case 4:
					if (queue.contains())
						System.out.println("Element is Present in Queue");
					else
						System.out.println("Queue does not contain it" );
					break;

				case 5: System.out.println("Queue Size "+queue.size());
						break;
						
				case 6:
					System.out.println("The Center Element is "+queue.center());
					break;
					
				case 7:
					System.out.println("queue After Sorting ");
					queue.sort();
					break;

				case 8:
					System.out.println("queue After Reversing");
					queue.reverse();
					break;

				case 9:
					System.out.println("Displaying items using iterator");
					queue.myIterator();
					break;
				case 10:
					System.out.println("Items present in queue are");
					queue.printQueue();
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
