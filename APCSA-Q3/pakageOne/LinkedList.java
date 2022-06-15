package pakageOne;

/**
 * Author: Sean Craig
 * Date: 13Jan2022
 * Description: LinkedList creates an object capable of
 * storing ListNode objects. There are also methods to check
 * and modify aspects of the LinkedList.
 */
public class LinkedList
{
	private ListNode start; // reference for first ListNode
	
	/**
	 * LinkedList constructor
	 */
	public LinkedList()
	{
		start = null;
	}
	
	/**
	 * isEmpty() checks to see if the LinkedList has no ListNodes
	 */
	public boolean isEmpty()
	{
		if (start == null)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * getFront() pulls off the first ListNode and returns
	 * the Object in it
	 */
	public Object getFront()
	{
		if (isEmpty()) { return null; };
		Object temp = start.getValue();
		start = start.getNext();
		return temp;
	}
	
	/**
	 * getBack() returns the Object stored in the last ListNode
	 */
	public Object getBack()
	{
		if (isEmpty()) { return null; }
		ListNode temp = start;
		// loops to end of LinkedList
		while (temp.getNext() != null)
		{
			temp = temp.getNext();
		}
		return temp.getValue();
	} 
	
	/**
	 * addFront(f) creates a ListNode with Object f
	 * and adds it to the front of the LinkedList
	 */
	public void addFront(Object f)
	{
		ListNode temp = new ListNode(f, start);
		start = temp;
	}
	
	/**
	 * addBack(b) creates a ListNode with Object b
	 * and adds it to the back of the LinkedList
	 */
	public void addBack(Object b)
	{	
		// if there are no ListNodes, adding anywhere will do
		if (isEmpty()) { addFront(b); }
		
		// the bellow code works only if there is a ListNode
		// already present in the LinkedList
		else
		{
			ListNode tracker = new ListNode(null, start);
		
			// cycles though each node, looking for the end of
			// the LinkedList
			while (tracker.getNext() != null)
			{
				// tracker is a node that copies other nodes as it goes down
				tracker = tracker.getNext(); 
			}
			ListNode temp = new ListNode(b, null);
			tracker.setNext(temp);
		}
	} 
	
	/**
	 * toString() creates and returns a String that lists
	 * the Object values in all the ListNodes of the LinkedList
	 */
	public String toString()
	{
		String tempString = "Values of LinkedList:" + '\n';
		if (isEmpty()) { return "There are no values!?"; }
		
		ListNode temp = start;
		
		// cycles through each ListNode and gets the value
		while (temp.getNext() != null)
		{
			tempString += temp.getValue() + " --> ";
			temp = temp.getNext();
		}
		// add the value of the last ListNode
		tempString += temp.getValue();
		return tempString;
	} 
}
