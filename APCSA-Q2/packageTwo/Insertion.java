package packageTwo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sean Craig
 * Date: 13Nov2021
 * Description: Insertion showcases the creation and sorting of
 * a List and an array of 100 random Integers. The values of each
 * before and after sorting are printed in the console
 * and written to a file, with there being 10 numbers
 * per line.
 */
public class Insertion 
{
	public static BufferedWriter out;
	
	/**
	 * makeList() creates and returns ArrayList of Integers 
	 * with random values between -1000 and 1000.
	 */
	public static ArrayList<Integer> makeList()
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		double sign; // Will help create negative numbers.
		for (int i=0; i<100; i++)
		{
			sign = Math.random();
			if(sign<0.5) { sign=-1; }
			list.add(i, (int)(Math.random()*1000*sign));
		}
		return list;
	}
	
	/**
	 * makeArray() creates and returns array of Integers 
	 * with random values between 0 and 100.
	 */
	public static Integer[] makeArray()
	{
		Integer arr[] = new Integer[100];
		double sign; // Will help create negative numbers
		for (int i=0; i<100; i++)
		{
			sign = Math.random();
			if(sign<0.5) { sign=-1; }
			arr[i] = (int)(Math.random()*1000*sign);
		}
		return arr;
	}

	/**
	 * insertionSort(param a) receives and sorts List of Integers
	 * by the values in each Integer from least to greatest.
	 */
	public static void insertionSort(List<Integer> a)
	{
		// currentsorted is index.
		for(int currentSorted=1; currentSorted<a.size(); currentSorted++)
		{
			// Stores Integer to be sorted so it can
			// be inserted later.
			Integer nextElement = a.get(currentSorted);
			
			// Index of previous Integer.
			int compareI = currentSorted-1;	
			
			// "Shifts over" Integers to make room for insertion by repeatedly
			// swapping until proper location is found.
			while ((compareI >= 0) && (a.get(compareI).compareTo(nextElement) > 0))
			{
				a.set(compareI+1, a.get(compareI));
				
				// compareI decreases so slots down List can be
				// checked to see if Integer value is greater
				// than Integer value at index currentSorted.
				compareI--;
			}
			// Replace Integer in correct slot after is is found
		 	a.set(compareI+1, nextElement);
		} 
	}
	
	/**
	 * selectionSort(param a) receives and sorts array of Integers
	 * by values in each Integer from least to greatest. 
	 */
	public static void selectionSort(Comparable<Integer> a[])
	{
		// endOfArray is slot number.
		// Loop runs through array of decreasing size (--slots-- <==).
		for(int endOfArray=a.length-1; endOfArray>0; endOfArray--)
		{
			Integer max = (Integer)a[0]; // start max at first element
			int maxIndex = 0;
			// Loop runs through array to find max.
			for (int i=0; i<=endOfArray; i++)
			{
				if (a[i].compareTo(max)>0) 
				{
					max = (Integer)a[i]; 
					maxIndex = i;
				}
			}
			// After finding max, swaps end of array with max
			// before shrinking array scope as max no longer
			// needs to be looked at.
			swap(a, maxIndex, endOfArray);
		} 
	}
	
	/**
	 * swap(param a, b, c) receives array of Integers, and indexes of array
	 * to be swaped, and swaps Integers.
	 */
	private static void swap(Comparable<Integer> a[], int b, int c)
	{
		Integer temp;
		temp = (Integer)a[b];
		a[b] = a[c];
		a[c] = temp;
		
	}
	
	
	/**
	 * print(param a, b, msg) creates a BufferedWriter, and receives a List
	 * and an array of Integers, as well as a String. This method
	 * uses other methods too create outputs in the console and
	 * a text file, listing the values of the Integers.
	 */
	public static void print(List<Integer> a, Comparable<Integer> b[], String msg) throws Exception
	{	
		// ArrayList listing.
        out.write(msg+" ArrayList listerine has these values:"+'\n');
		for(int i=0; i<100; i++)
	    {
			// Helps move Integer list to next line
			// after 10 values.
			if(i%10==9)
			{
				out.write(a.get(i).toString());
	          	   	
				// Helps end list (end of array) with period instead of comma.
				if(i==99)
				{
					out.write(".");
				}
				else 
				{
					out.write(", ");
				}
	         	   	
				// New line.
				out.write('\n');
			}
			else
			{
				out.write(a.get(i).toString()+", ");  
			}  
	    }
	    out.write('\n');	// Adds new line to make output easier to read.
	    
	    // Array listing.
        out.write(msg+" Array arr has these values:"+'\n');
        for(int i=0; i<100; i++)
        {
 			// Helps move Integer list to next line
 			// after 10 values.
        	if(i%10==9)
        	{
        		out.write(b[i].toString());
        		
        		// Helps end list (end of array) with period instead of comma.
        		if(i==99)
        		{
        			out.write(".");
        		}
        		else
        		{
        			out.write(", ");
        		}
        		
        		// New line.
        		out.write('\n');
        	}
        	else
        	{
        		out.write(b[i].toString()+", ");
        	}
        }
 		out.write('\n');	// Adds new line to make output easier to read.  
	}

	/**
	 * Main method.
	 */
	public static void main(String a[]) throws Exception
	{
		// Makes ArrayList and array of Integers
		ArrayList<Integer> listerine = makeList();
		Integer[] arr = makeArray();
		String fileOutputName = "insertionOut.txt";
		out = new BufferedWriter(new FileWriter(fileOutputName));
		
		// Creates and writes outputs.
		print(listerine, arr, "Original");
		insertionSort(listerine);
		selectionSort(arr);
		print(listerine, arr, "Sorted");
		out.close();	// Close file when done modifying.
	}
}