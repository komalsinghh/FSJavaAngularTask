package com.nagarro.assignment2.hashtable;

import java.util.Scanner;

public class HashTableDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter size of table");

		MyHashTable myht = new MyHashTable(scan.nextInt());

		char ch;

		do {
			System.out.println("\nHash Table Operations\n");
			System.out.println("1. Insert ");
			System.out.println("2. Delete");
			System.out.println("3. Search");
			System.out.println("4. Display");
			System.out.println("5. Size");
			System.out.println("6. Get value by key");
			System.out.println("7. Iterate Hash Table");

			System.out.println("Enter your choice");
			int choice = scan.nextInt();

		
			switch (choice) {

	
			case 1:

				System.out.println("Enter key and value");
				myht.insert(scan.next(), scan.next());
				
				break;

			case 2:
				System.out.println("Enter key");
				myht.remove(scan.next());
				break;

			case 3:

				System.out.println("Enter Key to search");
				if(myht.contains(scan.next()))
					System.out.println("HashTable Contains it");
				else
					System.out.println("No, it is not present");
				break;

			case 4:

				myht.printHashTable();
				break;

			case 5:

				System.out.println("Size = " + myht.getSize());
				break;
			case 6:
				System.out.println("Enter a key to get value");
				System.out.println(myht.get(scan.next()));
				break;
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			System.out.println("\nDo you want to continue (Type y or n) \n");

			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
		scan.close();
	}

}
