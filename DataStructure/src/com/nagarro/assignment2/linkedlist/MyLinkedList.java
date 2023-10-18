package com.nagarro.assignment2.linkedlist;

import java.util.Scanner;

public class MyLinkedList {
	LinkedListNode head;

	static class LinkedListNode {
		int data;
		LinkedListNode next;

		public LinkedListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Scanner sc = new Scanner(System.in);

	// Insert node at last....
	public void insertAtLast() {
		System.out.println("Enter an element to insert:");
		int data = sc.nextInt();
		LinkedListNode newNode = new LinkedListNode(data);
		if (head == null) {
			head = newNode;
		} else {
			LinkedListNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	// Insert node at position....
	public void insertAtPosition() {
		System.out.println("Enter value:");
		int data = sc.nextInt();
		System.out.println("Enter position:");
		int position = sc.nextInt();
		LinkedListNode newNode = new LinkedListNode(data);
		if (position == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			LinkedListNode temp = head;
			while (position != 1) {
				temp = temp.next;
				position--;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}

	// delete node from the last.....
	public void deleteAtLast() {
		LinkedListNode temp = head;
		LinkedListNode prev = null;

		if (temp.next == null) {
			head = null;
			return;
		}
		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
	}

	// delete node from position..
	public void deleteAtPosition() {
		System.out.println("Enter position:");
		int position = sc.nextInt();

		if (head == null) {
			return;
		}

		LinkedListNode temp = head;
		if (position == 0) {
			head = temp.next;
		}
		for (int i = 0; temp != null && i < position - 1; i++) {
			temp = temp.next;
		}

		LinkedListNode next = temp.next.next;
		temp.next = next;
	}

	public void sortList() {
		LinkedListNode current = head, index = null;

		int temp;

		if (head == null) {
			return;
		} else {
			while (current != null) {

				index = current.next;

				while (index != null) {
					if (current.data > index.data) {
						temp = current.data;
						current.data = index.data;
						index.data = temp;
					}

					index = index.next;
				}
				current = current.next;
			}
		}
	}

	// get middle of linkedlist..
	public void center() {
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
		}
		System.out.println(slow.data);
	}

//	public void sort(MyLinkedList list)

	// Reverse LinkedList...
	public void reverse() {
		LinkedListNode prev = null;
		LinkedListNode current = head;
		LinkedListNode next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	

	// get linkedlist size..
	public int getSize() {
		LinkedListNode temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	public NodeIterator iterateList() {
		return new NodeIterator(head);
	}

	// print linkedlist..
	public void printList() {
		LinkedListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("NULL");
	}
}
