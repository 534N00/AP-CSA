package packageTwo;

import java.util.ArrayList;

public class CodeStorage {

	
	
	
	
	
	
	
	
	
	
	

	
	
	// what is left, middle, and right?
	public static void splitter(ArrayList<Integer> toBeSplit, int leftI, 
						 int middleI, int rightI)
	{
		ArrayList<Integer> left = new ArrayList<Integer>();
		// vvv not toBeSplit.size()/2 as this must
		// be able to be used recursively
		int leftSize = middleI-leftI;
		for (int i=0; i<leftSize; i++)
		{
			left.add(i, toBeSplit.get(leftI+i));
		}
		// vvv not toBeSplit.size()-(toBeSplit.size()/2) for recursive use
		int rightSize = rightI-middleI;
		ArrayList<Integer> right = new ArrayList<Integer>();
		for (int i=0; i<rightSize; i++)
		{
			right.add(i, toBeSplit.get(middleI+1+i));
		}
		
		
		int leftStartI = 0, rightStartI = 0, tBSStartI = 1;
		
		// swaps nums in original list at same index in left and right list
		while (leftStartI < leftSize && rightStartI < rightSize)
		{
			if (left.get(leftStartI) <= right.get(rightStartI))
			{
				toBeSplit.set(tBSStartI, left.get(leftStartI));
				leftStartI++;
			}
			else
			{
				toBeSplit.set(tBSStartI, right.get(rightStartI));
			}
			tBSStartI++;
		}
		
		// merges left and right lists back together into original list
		while (leftStartI < leftSize)
		{
			toBeSplit.set(tBSStartI, left.get(leftStartI));
			leftStartI++;
			tBSStartI++;
		}
		// same merging as above
		while (rightStartI < rightSize)
		{
			toBeSplit.set(tBSStartI, right.get(rightStartI));
			rightStartI++;
			tBSStartI++;
		}
	}
	
	public void sort(ArrayList<Integer> a, int leftI, int rightI)
	{
		int middleI;
		if (leftI < rightI)
		{
			middleI = (leftI+rightI)/2;
			sort(a, leftI, middleI);
			sort(a, middleI+1, rightI); // middleI+1 to continue 
										// where above sort left off
			// merge sorted halves
			splitter(a, leftI, middleI, rightI);
		}
	}
	
	
	public static void main(String a[])
	{
		System.out.println("bang");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
