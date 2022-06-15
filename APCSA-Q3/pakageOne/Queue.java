package pakageOne;

/**
 * Author: Sean Craig
 * Date: 13Jan2022
 * Description: Queue declares methods to be used
 * in another class named QueueList.
 */
public interface Queue 
{
	/**
	 * isEmpty() should find if the QueueList has no ListNodes
	 */
	public boolean isEmpty();
	
	/**
	 * dequeue() should return the Object taken off the QueueList
	 */
	public Object dequeue();
	
	/**
	 * enqueue(o) should add a ListNode with Object o onto
	 * the end of the QueueList
	 */
	public Object enqueue(Object o);
	
	/**
	 * getFront() should return the Object stored in the front ListNode
	 */
	public Object getFront();
	
	/**
	 * getBack() should return the Object stored in the last ListNode 
	 */
	public Object getBack();
}
