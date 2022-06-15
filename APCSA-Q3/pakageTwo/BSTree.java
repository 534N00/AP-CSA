package pakageTwo;

/**
 * Author: Sean Craig
 * Date: 7Feb2022
 * Description: BSTree declares methods that will be used
 * for tree data structures.
 */
public interface BSTree 
{
	/**
	 * add(c) will be used to add objects to the tree
	 */
	public void add(Comparable c);
	
	/**
	 * search(c) will be used to see if an object is present in a tree
	 */
	public boolean search(Comparable c);
	
	/**
	 * height() will be used to find how many levels the tree goes down into
	 */
	public int height();
	
	/**
	 * toStringPreOrder() will create a String showing the structure of the tree
	 * in in-order form
	 */
	public String toStringPreOrder();
	
	/**
	 * toStringInOrder() will create a String showing the structure of the tree
	 * in pre-order form
	 */
	public String toStringInOrder();
	
	/**
	 * remove(c) will remove an object from the tree if present
	 */
	public void remove(Comparable c);
}
