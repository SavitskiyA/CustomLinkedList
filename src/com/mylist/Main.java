package com.mylist;

import java.util.Random;

/**
 * Demonstrate CustomLinkedList Class implementation
 * 
 * @author Andrey
 *
 */
public class Main {

	public static void main(String[] args) {

		CustomLinkedList<CustomWrapper> customLinkedList = new CustomLinkedList<>();

		System.out.println("Initial elements and add it to the list:");

		printElement(customLinkedList, new Random().nextInt(10));
		printElement(customLinkedList, new Random().nextInt(10));
		printElement(customLinkedList, new Random().nextInt(10));
		printElement(customLinkedList, new Random().nextInt(10));
		System.out.println("---------");

		System.out.println("Elements from list:");
		customLinkedList.printAll();
		System.out.println("---------");
		int index = 0;
		System.out.println("Elements from list by index " + index + ":");
		customLinkedList.printElement(0);
		System.out.println("---------");

		customLinkedList.removeFirstElement();
		System.out.println("Delete first element from list and print the whole list:");
		customLinkedList.printAll();
		System.out.println("---------");

		customLinkedList.removeLastElement();
		System.out.println("Delete last element from list and print the whole list:");
		customLinkedList.printAll();
		System.out.println("---------");
	}

	/**
	 * Method provides filling the list
	 * 
	 * @param customLinkedList
	 * @param num
	 */
	public static void printElement(CustomLinkedList<CustomWrapper> customLinkedList, int num) {
		System.out.println(num);
		customLinkedList.addFirstElement(new CustomWrapper(num));
	};
}
