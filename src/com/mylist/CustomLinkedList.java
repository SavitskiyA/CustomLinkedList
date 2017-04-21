package com.mylist;

import java.util.Iterator;

/**
 * Class provides parametrized bidirectional list, can contain only numbers and
 * strings
 * 
 * @author Andrey
 *
 * @param <CustomWrapper>
 */
public class CustomLinkedList<CustomWrapper> implements CustomLinker<CustomWrapper>, Iterable<CustomWrapper> {
	private Node<CustomWrapper> firstNode;
	private Node<CustomWrapper> lastNode;
	private int size = 0;

	public CustomLinkedList() {
		firstNode = new Node<CustomWrapper>(null, null, lastNode);
		lastNode = new Node<CustomWrapper>(firstNode, null, null);
		firstNode.setNextNode(lastNode);
	}

	/**
	 * Inner class describes element of list
	 * 
	 * @author Andrey
	 *
	 * @param <CustomWrapper>
	 */
	public class Node<CustomWrapper> {
		private CustomWrapper currentElement;
		private Node<CustomWrapper> nextNode;
		private Node<CustomWrapper> previousNode;

		public Node(Node<CustomWrapper> previousNode, CustomWrapper currentElement, Node<CustomWrapper> nextNode) {
			this.currentElement = currentElement;
			this.nextNode = nextNode;
			this.previousNode = previousNode;
		}

		public CustomWrapper getCurrentElement() {
			return currentElement;
		}

		public void setCurrentElement(CustomWrapper currentElement) {
			this.currentElement = currentElement;
		}

		public Node<CustomWrapper> getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node<CustomWrapper> nextNode) {
			this.nextNode = nextNode;
		}

		public Node<CustomWrapper> getPreviousNode() {
			return previousNode;
		}

		public void setPreviousNode(Node<CustomWrapper> previousNode) {
			this.previousNode = previousNode;
		}

	}

	/**
	 * 
	 * @param index
	 * @return true if index is within the size of the list
	 */
	private boolean isElementIndex(int index) {
		return index >= 0 && index < size;
	}

	/**
	 * 
	 * @param index
	 * @throws IndexOutOfBoundsException
	 *             if index isn't within the size of the list
	 */
	private void checkElementIndex(int index) {
		if (!isElementIndex(index))
			throw new IndexOutOfBoundsException("Index: " + index + "  Size: " + size());
	}

	
	@Override
	public void addFirstElement(CustomWrapper e) {
		Node<CustomWrapper> newNode = firstNode;
		newNode.setCurrentElement(e);
		firstNode = new Node<CustomWrapper>(null, null, newNode);
		newNode.setPreviousNode(firstNode);
		size++;
	}

	@Override
	public void addLastElement(CustomWrapper e) {
		Node<CustomWrapper> newNode = lastNode;
		newNode.setCurrentElement(e);
		lastNode = new Node<CustomWrapper>(newNode, null, null);
		newNode.setNextNode(lastNode);
		size++;

	}

	@Override
	public void addElement(CustomWrapper e) {
		addLastElement(e);
	}

	
	@Override
	public CustomWrapper getElement(int index) {
		checkElementIndex(index);
		Node<CustomWrapper> node = firstNode.getNextNode();
		for (int i = 0; i < index; i++) {
			node = node.getNextNode();
		}
		return node.getCurrentElement();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void printElement(int index) {
		System.out.println(getElement(index));
	}

	@Override
	public void printAll() {
		Node<CustomWrapper> node = firstNode.getNextNode();
		for (int i = 0; i < size; i++) {
			System.out.println(node.getCurrentElement());
			node = node.getNextNode();
		}

	}

	@Override
	public Iterator<CustomWrapper> iterator() {
		return new Iterator<CustomWrapper>() {
			int counter = 0;

			@Override
			public CustomWrapper next() {
				return getElement(counter++);
			}

			@Override
			public boolean hasNext() {
				return counter < size;
			}
		};
	}

	@Override
	public void removeFirstElement() {
		Node<CustomWrapper> node = firstNode.getNextNode();
		firstNode.setNextNode(node.getNextNode());
		CustomWrapper e = node.getCurrentElement();
		e = null;
		node = null;
		size--;
	}

	@Override
	public void removeLastElement() {
		Node<CustomWrapper> node = lastNode.getPreviousNode();
		lastNode.setPreviousNode(node.getPreviousNode());
		CustomWrapper e = node.getCurrentElement();
		e = null;
		node = null;
		size--;
	}

}
