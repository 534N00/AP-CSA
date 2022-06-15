package pakageTwo;

/**
 * Author: Sean Craig
 * Date: 7Feb2022
 * Description: TreeNode is a class that creates a means of 
 * storing Objects in an way that can be then put into a tree
 * data structure. There are methods to create a TreeNode, 
 * getting the address to other TreeNodes that may be linked
 * to be of greater or less value, and also for setting new TreeNodes
 * to be linked from the TreeNode referred to, and last but not least,
 * a method to change the value stored in a TreeNode.
 */
public class TreeNode 
{
	private Object value;
	private TreeNode left, right;
	
	/**
	 * Constructor
	 */
	public TreeNode (Object initValue, TreeNode initLeft, TreeNode initRight)
	{ 
		value = initValue; left = initLeft; right=initRight;
	}
	
	/**
	 * getValue() gets the Object stored in the TreeNode
	 */
	public Object getValue() { return value;}
	
	/**
	 * getLeft() gets the address to the TreeNode "to the left"
	 */
	public TreeNode getLeft() {return left;}
	
	/**
	 * getRight() gets the address to the TreeNode "to the right"
	 */
	public TreeNode getRight() {return right;}
	
	/**
	 * setValue(newValue) sets the value of this TreeNode to a different Object
	 */
	public void setValue (Object newValue) {value = newValue;}
	
	/**
	 * setLeft(newLeft) sets the left link to a new TreeNode
	 */
	public void setLeft (TreeNode newLeft) {left = newLeft;}
	
	/**
	 * setRight(newRight) sets the right link to a new TreeNode
	 */
	public void setRight (TreeNode newRight) {right = newRight;} 
}
