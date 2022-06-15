package pakageTwo;

/**
 * Author: Sean Craig
 * Date: 7Feb2022
 * Description: Canoer is a testing class for the methods of the Tree class
 */
public class Canoer 
{
	/**
	 * Main method
	 */
	public static void main(String a[])
	{
		Tree trunk1 = new Tree();
		trunk1.add("Bill");
		trunk1.add("Fred");
		trunk1.add("Joe");
		trunk1.add("Henrietta");
		trunk1.add("Mr. M");
		trunk1.add("Noman");
		trunk1.add("Alfred");
		trunk1.add("Al");
		trunk1.add("Fred");
		System.out.println("In-Order: "+trunk1.toStringInOrder());
		System.out.println("Pre-Order: "+trunk1.toStringPreOrder());
		trunk1.printLevelOrder();
		System.out.println();
		trunk1.mystery();
	//	System.out.println(trunk1.search("Fred"));
	}
}
