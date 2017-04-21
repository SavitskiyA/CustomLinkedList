package com.mylist;

/**
 * Interface implements method for list organization
 * 
 * @author Andrey
 *
 * @param <CustomWrapper>
 */
public interface CustomLinker<CustomWrapper> {
	/**
	 * Add element in the beginning of the list
	 * 
	 * @param e
	 */
	public void addFirstElement(CustomWrapper e);

	/**
	 * Add element to the end of the list
	 * 
	 * @param e
	 */
	public void addLastElement(CustomWrapper e);

	/**
	 * Add element to the list, to the end by default
	 * 
	 * @param e
	 */

	public void addElement(CustomWrapper e);

	/**
	 * 
	 * @return size of list
	 */

	public int size();

	/**
	 * 
	 * @param index
	 * @return content of list's object
	 */
	public CustomWrapper getElement(int index);

	/**
	 * Output of the element's content to the console
	 * 
	 * @param index
	 */
	public void printElement(int index);

	/**
	 * Output of the content of the all list's element to the console
	 */
	public void printAll();

	/**
	 * Remove first element of the list
	 */
	public void removeFirstElement();

	/**
	 * Remove last element of the list
	 */
	public void removeLastElement();

}
