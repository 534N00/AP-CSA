package packageOne;

/**
 * Author: Sean Craig
 * Date: 4Nov2021
 * Description: BossBaby creates an object with two boolean variables.
 * There are methods to get and set each variable individually, as well
 * as a method that creates a String telling of the values in the BossBaby.
 */
public class BossBaby 
{
	private boolean business1;
	private boolean business2;
	
	/**
	 * Constructor with parameters a and b.
	 */
	public BossBaby(boolean a, boolean b)
	{
		business1 = a;
		business2 = b;
	}
	
	/**
	 * getBusiness1() gets business1 value.
	 */
	public boolean getBusiness1()
	{
		return business1;
	}
	
	/**
	 * getBusiness2() gets business2 value.
	 */
	public boolean getBusiness2()
	{
		return business2;
	}
	
	/**
	 * setBusiness1() sets business1 value.
	 */
	public void setBusiness1(boolean a)
	{
		business1 = a;
	}
	
	/**
	 * setBusiness2() sets business2 value.
	 */
	public void setBusiness2(boolean b)
	{
		business2 = b;
	}
	
	/**
	 * toString() creates a String telling
	 * of the values in BossBaby.
	 */
	public String toString()
	{
		String temp = "The swapped Booleans are " + business1;
		temp += " and " + business2;
		return temp;
	}	
}
