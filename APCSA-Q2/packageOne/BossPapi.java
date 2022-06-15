package packageOne;

/**
 * Author: Sean Craig
 * Date: 4Nov2021
 * Description: BossPapi creates an object with a String.
 * There are methods to set and get the value of that String.
 */
public class BossPapi 
{
	public String name;
	
	/**
	 * Constructor with parameter n.
	 */
	public BossPapi(String n)
	{
		name = n;
	}
	
	/**
	 * setName() sets the value of name.
	 */
	public void setName(String n)
	{
		name = n;
	}
	
	/**
	 * getName returns the value of name.
	 */
	public String getName()
	{
		return name;
	}
}
