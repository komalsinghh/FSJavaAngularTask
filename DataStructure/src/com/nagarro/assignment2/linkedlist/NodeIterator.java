package com.nagarro.assignment2.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.nagarro.assignment2.linkedlist.MyLinkedList.LinkedListNode;

public class NodeIterator implements Iterator<LinkedListNode>{
	LinkedListNode next;
	public NodeIterator(LinkedListNode node) {
		this.next=node;
	}
	@Override
	public boolean hasNext() {
		return (next!=null);
	}
	@Override
	public LinkedListNode next() {
		if(next==null)
			throw new NoSuchElementException();
		LinkedListNode res=next;
		next=next.next;
		return res;
	}
}
