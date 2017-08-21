package com.metacube.main;

import java.util.Iterator;

import com.metacube.linkedlistinterface.MyLinkedList;
import com.metacube.singlylinkedlist.MySinglyLinkedList;

public class SinglyLinkedListMain {

	public static void main(String[] args) {
		MyLinkedList<String> list = new MySinglyLinkedList<String>();
		list.add("Chetan");
		list.add("Sharma");
		list.add("ABC");
		list.add("ABCD");
		list.add("abc");
		list.addFirst("cde");
		list.addLast("CDE");
		list.add(2,"Hello");
		System.out.println(list.indexOf("abc"));
		list.set(1, "Jems");
		list.set(2, "Jain");
		list.remove("Jain");
		System.out.println(list);
		list.reverse();
		list.sort();
		System.out.println(list);
	}

}
