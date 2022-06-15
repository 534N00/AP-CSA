package pakageTwo;

import pakageOne.QueueList;

/**
 * Author: Sean Craig
 * Date: 7Feb2022
 * Description: Tree is a representation of a basic tree data structure
 * that uses methods declared in the BSTree interface. There are methods
 * that add Objects to the Tree, search for an Object
 */
public class Tree implements BSTree
{
	private TreeNode root; // base of tree
	
	/**
	 * Constructor
	 */
	public Tree() { root = null; }
	
	/**
	 * add(c) adds Comparable c somewhere in the Tree below TreeNode root
	 */
	public void add(Comparable c)
	{
		root = addValue(c, root);
	}
	
	/**
	 * addValue(c, tempR) adds Comparable c somewhere in the Tree below TreeNode tempR
	 * to the lowest level appropriate
	 */
	public TreeNode addValue(Comparable c, TreeNode tempR)
	{
		if (tempR == null) // adding as leaf
		{
			tempR = new TreeNode(c, null, null);
		}
		else // running down the branches
		{
			if(c.compareTo((Comparable)tempR.getValue()) <= 0)
			{
				tempR.setLeft(addValue(c, tempR.getLeft()));
			}
			else
			{
				tempR.setRight(addValue(c, tempR.getRight()));
			}
		}
		return tempR;
	}
	
	/**
	 * search(c) looks through the entire Tree
	 * to see if the target Comparable c is present
	 */
	public boolean search(Comparable c) { return searchP(c, root); }
	
	/**
	 * searchP(c, tempR) looks through the Tree including and below
	 * TreeNode tempR to see if target Comparable c is present
	 */
	public boolean searchP(Comparable c, TreeNode tempR)
	{
		if(tempR == null) { return false; } // is Empty?
		else
		{
			if(c.equals((Comparable)tempR.getValue()))
			{
				return true;
			}
			else
			{
				// recursively traces though branches
				return (searchP(c, tempR.getLeft()) || searchP(c, tempR.getRight()));
			}
		}
	}
	
	/**
	 * height() finds the number of "levels" below the first TreeNode, root
	 */
	public int height() { return heightP(root); }
	
	/**
	 * heightP(temprR) finds the number of "levels" below and including
	 * TreeNode tempR
	 */
	private int heightP(TreeNode tempR)
	{
		if (tempR == null) { return 0; }
		
		// recursion compounds the counter
		return 1+Math.max(heightP(tempR.getLeft()), heightP(tempR.getRight()));
	}
	
	/**
	 * toStringInOrder() creates a String listing branches
	 * starting from the first TreeNode, the root, in pre-order form
	 */
	public String toStringPreOrder()
	{
		return toStringPre(root);
	}
	
	/**
	 * toStringPre(tempR) creates a String listing branches starting
	 * at the tempR TreeNode pre-order form (P,L,R)
	 */
	private String toStringPre(TreeNode tempR)
	{
		if(tempR == null) { return ""; }
		else
		{
			return "(" + tempR.getValue() +
				   " " + toStringPre(tempR.getLeft()) +
				   " " + toStringPre(tempR.getRight()) + ")";
		}
	}
	
	/**
	 * toStringInOrder() creates a String listing branches
	 * starting from the first TreeNode, the root, in in-order form
	 */
	public String toStringInOrder()
	{
		return toStringP(root);
	}
	
	/**
	 * toStringP(tempR) creates a String listing branches starting
	 * at the tempR TreeNode in in-order form (L,P,R)
	 */
	private String toStringP(TreeNode tempR)
	{
		if(tempR == null) { return ""; }
		else 
		{
			return "(" + toStringP(tempR.getLeft()) +
					" " + tempR.getValue() +
					" " + toStringP(tempR.getRight()) + ")";
		}
	}
	
	/**
	 * remove(c) should be made to remove a TreeNode from the tree
	 * but I don't feel like it so instead the answer is 42
	 */
	public void remove(Comparable c)
	{
		int answer = 42;
	}
	
	/**
	 * printLevelOrder() will print the nodes in the order by level
	 */
	public void printLevelOrder()
    {
        int h = heightP(root);
        
        // The iteration runs by level too
        for (int i=1; i<=h; i++)	
        {
        	// every time recursion occurs, the entire Tree is traced
        	// until level target (i) is reached
        	printCurrentLevel(root, i);
        }
    }
	
	/**
	 * printCurrentLevel() is a helper method for recursively 
	 * printing out the values in the nodes at a "level".
	 */
	public void printCurrentLevel(TreeNode tempR, int level)
    {
        if (tempR == null) { return; }
	    if (level == 1)
	    	{ System.out.print(tempR.getValue() + " "); }
	    else if (level > 1) 
	    {
	            printCurrentLevel(tempR.getLeft(), level - 1);
	            printCurrentLevel(tempR.getRight(), level - 1);
	    }
	}
	
	public void mystery()

	{
		TreeNode tempR = root;
	      QueueList temp = new QueueList();
	      if (tempR != null)
	      {
	            temp.enqueue(tempR);

	            while(!temp.isEmpty())

	            {

	                  tempR = (TreeNode) temp.dequeue();

	                  System.out.print(tempR.getValue() + "   ");

	                  if (tempR.getLeft() != null)

	                        temp.enqueue(tempR.getLeft() );

	                  if (tempR.getRight() != null)

	                        temp.enqueue(tempR.getRight());
	            }
	      }
	}
}
