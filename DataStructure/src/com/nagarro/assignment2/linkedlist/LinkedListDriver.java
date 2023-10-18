package com.nagarro.assignment2.linkedlist;

import java.util.Scanner;

public class LinkedListDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ans = ' ';
		MyLinkedList linkedList = new MyLinkedList();
		do {
			System.out.println("**********************************************");
			System.out.println("Enter 1 for Insertion");
			System.out.println("Enter 2 for Insert at any position");
			System.out.println("Enter 3 to Delete");
			System.out.println("Enter 4 for Delete at any position");
			System.out.println("Enter 5 for linkedList Size");
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
				case 1:
					linkedList.insertAtLast();

					break;

				case 2:
			
					linkedList.insertAtPosition();
					break;

				case 3:
					linkedList.deleteAtLast();
					break;

				case 4:
					linkedList.deleteAtPosition();
					break;

				case 5:
					System.out.println("The Size of linked list is=" + linkedList.getSize());
					break;

				case 6:
					linkedList.center();
					break;

				case 7:
					System.out.println("LinkedList Sorted ");
					linkedList.sortList();
					break;

				case 8:
					System.out.println("LinkedList Reversed");
					linkedList.reverse();
					break;

				case 9:
					System.out.print("Iterating the LinkedList using Iterator : ");
					NodeIterator itr=linkedList.iterateList();
					while(itr.hasNext()) {
						System.out.print(itr.next().data+" ");
					}
					break;
				case 10:
					System.out.println("Items present in linkedList are");
					linkedList.printList();
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
