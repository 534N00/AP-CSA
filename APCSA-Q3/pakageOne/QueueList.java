package pakageOne;

/**
 * Author: Sean Craig
 * Date: 15Jan2022
 * Description: QueueList creates a QueueList object
 * which is a LinkedList. QueueList has methods to check and modify
 * aspects of the object using methods pre-declared in the Queue interface.
 * (is supposed to match structure of real-world queue)
 */
public class QueueList extends LinkedList implements Queue
{
	/**
	 * isEmpty() finds if the QueueList has no ListNodes
	 */
	public boolean isEmpty()
	{
		return super.isEmpty();
	}
	
	/**
	 * dequeue() returns the Object taken off the QueueList
	 */
	public Object dequeue()
	{
		return super.getFront();
	}
	
	/**
	 * enqueue(o) adds a ListNode with Object o onto
	 * the end of the QueueList
	 */
	public Object enqueue(Object o)
	{
		super.addBack(o);
		return o;
	}
	
	/**
	 * getFront() returns the Object stored in the front ListNode
	 */
	public Object getFront()
	{
		if (isEmpty()) { return null; }
		// takes off ListNode and stores the Object
		Object hold = super.getFront(); 
		// puts the ListNode back into the StackList
		super.addFront(hold);
		return hold;
	}
	
	/**
	 * getBack() returns the Object stored in the last ListNode 
	 */
	public Object getBack()
	{
		return super.getBack();
	}
}
