package com.nagarro.assignment2.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class MyStack {
	int top = 0;
	ArrayList<Integer> stack = new ArrayList<Integer>();
	Scanner sc = new Scanner(System.in);

	void push() {
		System.out.println("Enter a value:");
		int data = sc.nextInt();
		stack.add(data);
	}

	void pop() {
		if (stack.size() == 0) {
			System.out.println("Stack is empty, please enter some value.");
		} else {
			top = stack.size() - 1;
			stack.remove(top);
		}
	}

	int peek() {
		top = stack.size() - 1;
		return stack.get(top);
	}

	boolean contains() {
		System.out.println("Enter a value to search:");
		int value = sc.nextInt();
		for (Integer element : stack) {
			if (value == element)
				return true;
		}
		return false;
	}

	int size() {
		return stack.size();
	}

	int center() {
		int middleValue = size() / 2;
		return stack.get(middleValue);
	}

	void reverse() {
		for (int i = 0; i < stack.size() / 2; i++) {
			int temp = stack.get(i);
			stack.set(i, stack.get(stack.size() - i - 1));
			stack.set(stack.size() - i - 1, temp);
		}
	}

	void myIterator() {
		Iterator<Integer> iter = stack.iterator();

		System.out.println("\nThe iterator values" + " of list are: ");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
	
	void sort() {
		Collections.sort(stack);
	}
	public void displayStack() {
		System.out.print("Stack [ ");
		for (int i=stack.size()-1;i>=0;i--) {
			System.out.print(stack.get(i)+" ");
		}
		System.out.print("]");
		
	}

}
