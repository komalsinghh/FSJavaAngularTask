package com.nagarro.assignment2.priorityqueue;

import java.util.*;

public class MyPriorityQueue {

	int lastIndex = 0;
	ArrayList<Integer> myPQueue = new ArrayList<Integer>();

	Scanner sc = new Scanner(System.in);

	void enqueue() {
		System.out.println("Enter value to add:");
		int data = sc.nextInt();
		myPQueue.add(data);
		Collections.sort(myPQueue, new MyComparator());
	}
	void dequeue() {
		if (myPQueue.size() == 0) {
			System.out.println("Queue is empty, please enter some value");
		} else {
			myPQueue.remove(lastIndex);
		}
	}

	int peek() {
		return myPQueue.get(lastIndex);
	}

	boolean contains() {
		System.out.println("Enter value:");
		int value = sc.nextInt();
		for (int element : myPQueue) {
			if (value == element) {
				return true;
			}
		}
		return false;
	}

	int size() {
		return myPQueue.size();
	}

	int center() {
		int stackSize = size();
		int midIndex = stackSize / 2;
		return myPQueue.get(midIndex);
	}

	void reverse() {
		for (int i = 0; i < myPQueue.size() / 2; i++) {
			Integer temp = myPQueue.get(i);
			myPQueue.set(i, myPQueue.get(myPQueue.size() - i - 1));
			myPQueue.set(myPQueue.size() - i - 1, temp);
		}
	}
	void myIterator() {
		Iterator<Integer> iter = myPQueue.iterator();

		System.out.println("\nThe iterator values" + " of list are: ");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}

	void printQueue() {
		System.out.print("Queue [ ");
		for (int value : myPQueue) {
			System.out.print(value+" ");
		}
		System.out.print("]");
	}

}

class MyComparator implements Comparator<Integer> {

	public int compare(Integer s1, Integer s2) {
		if (s1 < s2)
			return 1;
		else if (s1 > s2)
			return -1;
		return 0;
	}
}