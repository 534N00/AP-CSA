package pakageTwo;

import java.util.ArrayList;

/**
 * Author: Sean Craig
 * Date: 22March2022
 * Description: Heap is a representation of the heap data structure.
 * This particular heap is a min heap. There are methods that allow
 * for manipulating and inspecting aspects of the heap.
 */
public class Heap 
{
	private ArrayList<Comparable> mainList;
	
	/**
	 * Constructor
	 */
	public Heap()
	{
		mainList = new ArrayList<Comparable>();
		mainList.add(null);
	}
	
	/**
	 * add(c) appends the heap with a new value and puts
	 * it at a correct place.
	 */
	public boolean add(Comparable c)
	{
		if (c == null) { return false; }
		int cIndex = mainList.size();
		int parentI;
		
		// prevents out of bounds error with empty heap
		if (cIndex <2) { parentI = 1; }
		else { parentI = cIndex/2; }
		
		Comparable temp;
		mainList.add(c);

		// checks if the value needs to be adjusted up
		while(parentI!=0 && (mainList.get(parentI)).compareTo(c)>0)
		{
			// swap
			temp = mainList.get(parentI);
			mainList.set(parentI, c);
			mainList.set(cIndex, temp);
				
			// update indexes before next comparison
			cIndex = parentI;
			parentI = cIndex/2;
		}
		return true;
	}
	
	/**
	 * removeMin() removes the minimum value from the heap
	 * and then adjusts everything so that the heap form
	 * is maintained correctly.
	 */
	public Comparable removeMin()
	{
		if (isEmpty()) { return null; }
		Comparable hold = peekMin(); // hold onto the value until corrections are complete
		int size = mainList.size();
		int pI = 1; int lI = 2; int rI = 3; int compL; int compR; 
		Comparable temp; // for swaps
		
		// Set last value on top.
		// This fixes any issue with there being a 
		// "parent with one child.
		mainList.set(1, mainList.get(size-1));
		
		while(lI<size-1) // this works but I'd rather put smtg else
		{
			// finding which child to swap with
			compL = mainList.get(pI).compareTo(mainList.get(lI));
			compR = mainList.get(pI).compareTo(mainList.get(rI));
			
			// to stop the loop when the perfect spot is found
			if(compL<0 && compR<0) 
			{
				mainList.remove(size-1);
				return hold; 
			}
			
			if(compL>=compR)
			{
				temp = mainList.get(pI);
				mainList.set(pI, mainList.get(lI));
				mainList.set(lI, temp);
				pI = lI;
				lI = pI*2;
				rI = pI*2+1;
			}
			else if(compL<compR)
			{
				temp = mainList.get(pI);
				mainList.set(pI, mainList.get(rI));
				mainList.set(rI, temp);
				pI = rI;
				lI = pI*2;
				rI = pI*2+1;
			}
		}
		mainList.remove(size-1);
		return hold;
	}
	
	/**
	 * peekMin() just shows what the minimum value is in the heap.
	 */
	public Comparable peekMin() 
	{
		return mainList.get(1);
	}
	
	/**
	 * isEmpty() checks if the heap is empty.
	 */
	public boolean isEmpty()
	{
		if(mainList.size()<2) { return true; }
		return false;
	}
	
	/**
	 * toString() returns a string representing what is in the heap
	 */
	public String toString()
	{
		if(isEmpty()) { return "Na na na na boo boo heap is basicaly empty"; }
		return mainList.toString();
	}
}
