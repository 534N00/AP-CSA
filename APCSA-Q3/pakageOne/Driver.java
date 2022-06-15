package pakageOne;

/**
 * Author: Sean Craig
 * Date: 15Jan2022
 * Description: Driver test methods StackList and QueueList
 */
public class Driver 
{
	public static void main(String a[])
	{
		String n1, n2, n3, n4, n5, n6;
		n1 = "Bill"; n2 = "Fred"; n3 = "Joe";
		n4 = "Henrietta"; n5 = "Mr. M"; n6 = "Noman";
		StackList stack = new StackList();
		QueueList queue = new QueueList();
		System.out.println("stack empty? "+stack.isEmpty());
		System.out.println("queue empty? "+queue.isEmpty());
		System.out.println();
		
		stack.push(n6); // Noman
		stack.push(n5); // Mr. M
		stack.push(n4); // Henrietta
		stack.push(n3); // Joe
		stack.push(n2); // Fred
		stack.push(n1); // Bill
		System.out.println(stack.toString());
		System.out.println("stack empty? "+stack.isEmpty());
		System.out.println("the first node's value is "+stack.peek());
	
		System.out.println("Bill is node "+stack.search(n1));
		System.out.println("Joe is node "+stack.search(n3));
		System.out.println("Noman is node "+stack.search(n6));
		System.out.println("Where is Dora? "+stack.search("Dora"));
		System.out.println();
		
		queue.enqueue(n1);
		queue.enqueue(n2);
		queue.enqueue(n3);
		queue.enqueue(n4);
		queue.enqueue(n5);
		queue.enqueue(n6);
		System.out.println(queue.toString());
		System.out.println("queue empty? "+queue.isEmpty());
		System.out.println("front node value is "+queue.getFront());
		System.out.println("back node value is "+queue.getBack());
		System.out.println();
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		System.out.println("What is in queue after dequeue-ing 5 times? "
				+'\n'+queue.toString());
	}
}
