package pakageOne;

/**
 * Author: Sean Craig
 * Date: 13Jan2022
 * Description: Stack declares methods to be used
 * in another class named StackList.
 */
public interface Stack 
{
	/**
	 * isEmpty() should find if the StackList has no ListNodes
	 */
	public boolean isEmpty();
	
	/**
	 * push(o) should add a ListNode storing Object o
	 * to the front of the StackList and returns o.
	 */
	public Object push(Object o);
	
	/**
	 * pop() should remove a ListNode from the front of the StackList
	 * and returns the Object that was stored in it.
	 */
	public Object pop();
	
	/**
	 * peek() should return the Object stored in the first ListNode
	 * without removing it from the StackList. 
	 */
	public Object peek();
	
	/**
	 * search(target) will try to find a ListNode in the StackList
	 * that is storing an Object equal to the target
	 */
	public int search(Object o);
}
