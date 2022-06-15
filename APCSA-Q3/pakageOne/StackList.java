package pakageOne;

/**
 * Author: Sean Craig
 * Date: 13Jan2022
 * Description: StackList creates a StackList object
 * which is a LinkedList. StackList has methods to check and modify
 * aspects of the object using methods pre-declared in the Stack interface.
 * (is supposed to match structure of real-world stack)
 */
public class StackList extends LinkedList implements Stack
{	
	/**
	 * StackList constructor using LinkedList constructor
	 */
	public StackList()
	{
		super(); 
	}
	
	/**
	 * isEmpty() finds if the StackList has no ListNodes
	 */
	public boolean isEmpty()
	{
		return super.isEmpty();
	}
	
	/**
	 * push(o) adds a ListNode storing Object o
	 * to the front of the StackList and returns o.
	 */
	public Object push(Object o) // why is push returning when it is same as addtofront?
	{
		super.addFront(o); 
		return o;
	}
	
	/**
	 * pop() removes a ListNode from the front of the StackList
	 * and returns the Object that was stored in it.
	 */
	public Object pop()
	{
		if (isEmpty()) { return null; }
		return super.getFront(); 
	}
	
	/**
	 * peek() returns the Object stored in the first ListNode
	 * without removing it from the StackList. 
	 */
	public Object peek()
	{
		if (isEmpty()) { return null; }
		// takes off ListNode and stores the Object
		Object hold = super.getFront(); 
		// puts the ListNode back into the StackList
		super.addFront(hold);
		return hold;
	}
	
	/**
	 * search(target) tries to find a ListNode in the StackList
	 * that is storing an Object equal to the target
	 */
	public int search(Object target)
	{
		if (isEmpty()) { return -1; }
		StackList tempBox = new StackList();
		int stackNum = 0; // location of node minus 1
		int isThere = 0;  // like a boolean
		// pop and check
		while (!isEmpty() && !this.peek().equals(target)) 
		{
			tempBox.push(this.pop());
			stackNum++;
		}
		
		// if all ListNodes have been popped off
		// then none of them matched the target
		if (isEmpty()) { isThere = -1; }
		
		// puts ListNodes back on StackList in correct order
		// (stackNum is really used for correct number of iterations)
		for (int i=0; i<stackNum; i++)
		{
			push(tempBox.pop());
		}
		
		if (isThere == -1) { return isThere; }
		return stackNum+1;
	}
}

