package com.nagarro.assignment2.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class MyQueue {

	int lastIndex = 0;
	ArrayList<Integer> myQueue = new ArrayList<Integer>();

	Scanner sc = new Scanner(System.in);

	void enqueue() {
		System.out.println("Enter value to add:");
		int data = sc.nextInt();
		myQueue.add(data);
	}

	void dequeue() {
		if (myQueue.size() == 0) {
			System.out.println("Queue is empty, please enter some value");
		} else {
			lastIndex = myQueue.size() - 1;
			myQueue.remove(lastIndex);
		}
	}

	int peek() {
		lastIndex = myQueue.size() - 1;
		return myQueue.get(lastIndex);
	}

	boolean contains() {
		System.out.println("Enter value:");
		int value = sc.nextInt();
		for (int element : myQueue) {
			if (value == element) {
				return true;
			}
		}
		return false;
	}

	int size() {
		return myQueue.size();
	}

	int center() {
		int stackSize = size();
		int midIndex = stackSize / 2;
		return myQueue.get(midIndex);
	}

	void reverse() {
		for (int i = 0; i < myQueue.size() / 2; i++) {
			Integer temp = myQueue.get(i);
			myQueue.set(i, myQueue.get(myQueue.size() - i - 1));
			myQueue.set(myQueue.size() - i - 1, temp);
		}
	}
	void myIterator() {
		Iterator<Integer> iter = myQueue.iterator();

		System.out.println("\nThe iterator values" + " of list are: ");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
	void sort() {
		Collections.sort(myQueue);
	}
	void printQueue() {
		System.out.println("Queue [ ");
		for (int value : myQueue) {
			System.out.print(value+" ");
		}
		System.out.print(" ]");
	}

}
