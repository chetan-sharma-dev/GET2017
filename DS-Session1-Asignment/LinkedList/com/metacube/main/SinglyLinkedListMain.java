package com.metacube.main;


import com.metacube.linkedlistinterface.MyLinkedList;
import com.metacube.singlylinkedlist.MySinglyLinkedList;

public class SinglyLinkedListMain {

	public static void main(String[] args) {
		MyLinkedList<String> list = new MySinglyLinkedList<String>();
		list.add("Chetan");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.addFirst("L");
		list.addLast("M");
		list.add(2,"p");
		System.out.println(list.indexOf("N"));
		list.set(1, "E");
		list.set(2, "e");
		list.remove("F");
		System.out.println(list);
		list.reverse();
		list.sort();
	}

}
