package packageTwo;

import java.util.List;
import java.util.ArrayList;

/**
 * Author: Sean Craig
 * Date: 23Nov2021
 * Description: Sorts is a class that has the QuickSort algorithm
 * for arrays, and the MergeSort algorithm for ArrayLists.
 * The main method tests multiple instances of both algorithms 
 * working. For this there are methods to make different
 * arrays and ArrayLists, and of course the methods quickSort(),
 * partition(), and swap() for QuickSort, along with the methods mergeSort()
 * and merge() for MergeSort. The output of everything is written
 * reasonably nicely in the console with the help of two methods,
 * printArray() and printList().
 */
public class Sorts 
{
	/**
	 * makeRandomArray() creates and returns an array of ints 
	 * with however many random values between between 0 and 100
	 * one could dream of.
	 */
	public static int[] makeRandomArray(int length)
	{
		int[] arr = new int[length];
		for (int i=0; i<length; i++)
		{
			arr[i] = (int)(Math.random()*100);
		}
		return arr;
	}
	
	/**
	 * makeSortedArray() creates and returns an array of ints 
	 * with pre-sorted values from 1 to whatever the array length is.
	 */
	public static int[] makeSortedArray(int length)
	{
		int[] arr = new int[length];
		for (int i=0; i<length; i++)
		{
			arr[i] = i+1;
		}
		return arr;
	}
	
	/**
	 * makeSortedArrayR() creates and returns an array of ints 
	 * with pre-sorted values from whatever the array length is
	 * to 1.
	 */
	public static int[] makeSortedArrayR(int length)
	{
		int[] arr = new int[length];
		for (int i=0; i<length; i++)
		{
			arr[i] = length-i;
		}
		return arr;
	}
	
	/**
	 * makeRandomList() creates and returns ArrayList of Integers 
	 * with however many random values between 0 and 100 
	 * one could dream of.
	 */
	public static ArrayList<Comparable<Integer>> makeRandomList(int size)
	{
		ArrayList<Comparable<Integer>> list = new ArrayList<Comparable<Integer>>();
		for (int i=0; i<size; i++)
		{
			list.add(i, (int)(Math.random()*100));
		}
		return list;
	}
	
	/**
	 * makeSortedList() creates and returns an ArrayList of Integers 
	 * with pre-sorted values from 1 to whatever the List size is.
	 */
	public static ArrayList<Comparable<Integer>> makeSortedList(int size)
	{
		ArrayList<Comparable<Integer>> list = new ArrayList<Comparable<Integer>>();
		for (int i=0; i<size; i++)
		{
			list.add(i, i+1);
		}
		return list;
	}
	
	/**
	 * makeSortedArrayR() creates and returns an ArrayList of Integers
	 * with pre-sorted values from whatever the List size is to 1.
	 */
	public static ArrayList<Comparable<Integer>> makeSortedListR(int size)
	{
		ArrayList<Comparable<Integer>> list = new ArrayList<Comparable<Integer>>();
		for (int i=0; i<size; i++)
		{
			list.add(i, size-i);
		}
		return list;
	}
	
	
	/**
	 * quickSort() sorts an array using a "divide and conquer" strategy.
	 * An sorting occurs through recursively focusing on halves sorting 
	 * very loosely based on one element at a time. By the time the
	 * halving has gone to where each half is one element 
	 * (a lot of halves throughout the array), the sorting is complete.
	 */
	public static void quickSort(int[] a, int frontI, int backI)
	{
		int middleI;
		
		// If statement will stop recursion when sections are one element.
		if (frontI < backI)
		{
			// Split array into to metaphorical halves
			// by finding a middle index.
			middleI = partition(a, frontI, backI);
			
			// Recursively quickSort on each half.
			quickSort(a, frontI, middleI-1);
			quickSort(a, middleI+1, backI);
		}
	}
	
	/**
	 * partition() loosely sorts by taking
	 * a pivot value, and moving all others to the left or right of it
	 * depending if the value is less or more than the pivot value.
	 * It returns the pivot value's index after it has been put in the
	 * appropriate spot relative to itself.
	 */
	public static int partition(int[] a, int frontI, int backI) 
	{
	
		int leftIndex = frontI;
		int rightIndex = backI;
		int pivotValue = a[frontI];
		
		// Runs until left and right cross.
		while(leftIndex <= rightIndex)
		{
			// Looking for first element above pivotValue (checks left to right).
			// Also checks to see if we are partitioning last element 
			// so we don't have an out of bounds exception.
			// Ex: Index 6 out of bounds for length 6 due to leftIndex
			// plus plus-ing too far.
			while(leftIndex != a.length && a[leftIndex]<=pivotValue)
			{
				leftIndex++;
			}
			
			// Looking for first element below pivotValue (checks right to left).
			while(a[rightIndex]>pivotValue)
			{
				rightIndex--;
				
			}
			// Swaps left and rightIndex after first high and low are found.
			// Must be conditional so when left and right cross we don't
			// swap unnecessarily.
			if (leftIndex<rightIndex)
			{
			
				swap(a, leftIndex, rightIndex);
				
			}
		}
		// Swap pivot element to place where it should go to be sorted,
		// with all values less to the left, and all greater values
		// to the right.
		swap(a, rightIndex, frontI);
		
		// Return final index location of pivot element.
		return rightIndex;
	}
	
	/**
	 * swap() is a simple method to swap values
	 * in an array.
	 */
	public static void swap(int[] in, int a, int b)
	{
		int temp = in[a];
		in[a] = in[b];
		in[b] = temp;
	}

	/**
	 * mergeSort() sorts ArrayList of Integers by:
	 * 1) Recursively splitting up Lists into two smaller Lists 
	 * 	  until each elements is in their own List of size 1.
	 * 2) Recursively merging (through merge method) Lists back together,
	 *    sorting along the way.
	 */
	public static void mergeSort(ArrayList<Comparable<Integer>> inputList)
	{
		int listLength = inputList.size();
		
		/* First check if List is already 1 element long. */
		if (listLength < 2)
		{
			return;
		}
		
		/* Split input List in half */ 
		int middleI = listLength/2;
		ArrayList<Comparable<Integer>> leftHalf = new ArrayList<Comparable<Integer>>();
		for (int l=0; l<middleI; l++)
		{
			leftHalf.add(l, inputList.get(l));
		}
		ArrayList<Comparable<Integer>> rightHalf = new ArrayList<Comparable<Integer>>();
		for (int r=middleI; r<listLength; r++)
		{
			rightHalf.add(r-middleI, inputList.get(r));
		}
		
		// Recursively call mergeSort() to continue splitting Lists.
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		
		// Finally merge together the Lists, sorting with every
		// replaced value. This line will be reached after 
		// List size comparator return statement runs. 
		merge(inputList, leftHalf, rightHalf);
	}
	
	/**
	 * merge() merges together two ArrayList<Integer>s
	 * while sorting the elements. This is done by comparing elements in both halves
	 * one by one, and replacing it in the inputList.
	 */
	public static void merge(List<Comparable<Integer>> inputList, ArrayList<Comparable<Integer>> leftHalf, ArrayList<Comparable<Integer>> rightHalf)
	{
		int leftSize = leftHalf.size();
		int rightSize = rightHalf.size();
		
		// Iterators will be used for sorting+merging
		int leftIterator=0, rightIterator=0, mergedIterator=0;
		
		/* Sort of slots them one after the other, like two semi-automatic machine guns.
		 * If one bullet(value) is less than the other, fire that lesser bullet
	     * into the inputList. Then compare the next bullet in the
	     * magazine(leftHalf/rightHalf List) with the bullet that was
	     * greater previously.
		 */
		while (leftIterator < leftSize && rightIterator < rightSize)
		{
			// Shoot value in leftHalf.
			if (leftHalf.get(leftIterator).compareTo((Integer)rightHalf.get(rightIterator))<=0)
			{
				inputList.set(mergedIterator, leftHalf.get(leftIterator));
				leftIterator++;
			}
			// Shoot value in rightHalf.
			else
			{
				inputList.set(mergedIterator, rightHalf.get(rightIterator));
				rightIterator++;
			}
			mergedIterator++;
		}
		
		// When one magazine is empty,
	    // fire off the rest of the bullets in the other rifle.
		while (leftIterator < leftSize) // Left rifle.
		{
			inputList.set(mergedIterator, leftHalf.get(leftIterator));
			mergedIterator++;
			leftIterator++;
		}
		while (rightIterator < rightSize) // Right rifle.
		{
			inputList.set(mergedIterator,  rightHalf.get(rightIterator));
			mergedIterator++;
			rightIterator++;
		}
	}

	/**
	 * printList() creates and returns a String listing the values
	 * in a List.
	 */
	public static String printList(List<Comparable<Integer>> a)  
	{   
		String str = "";
		for (int i=0; i<a.size(); i++)  
		{	
			if((i+1)%10 == 0)
			{
				str+= a.get(i).toString();
				
	          	   	
				// Helps end list (end of array) with period instead of comma.
				if(i == a.size()-1)
				{
					str += ".";
				}
				else 
				{
					str += ", ";
				}
	         	   	
				// New line.
				str += '\n';
			}
			else
			{  
				if(i== a.size()-1)
				{
					str += a.get(i).toString() + "." + '\n';
				}
				else
				{
					str += a.get(i).toString()+", ";
				}
			}   
	    }  
		return str;
	}
	
	/**
	 * printArray() creates and returns a String listing the values
	 * in an array.
	 */
	public static String printArray(int[] a)  
	{   
		String str = "";
		for (int i=0; i<a.length; i++)  
		{	
			if((i+1)%10 == 0)
			{
				str+= a[i];
				
	          	   	
				// Helps end list (end of array) with period instead of comma.
				if(i == a.length-1)
				{
					str += ".";
				}
				else 
				{
					str += ", ";
				}
	         	   	
				// New line.
				str += '\n';
			}
			else
			{  
				str += a[i];
				
				if(i == a.length-1)
				{
					str += "." + '\n';
				}
				else 
				{
					str += ", ";
				}
			}   
	    }  
		return str;
	}
	
	/**
	 * Main method.
	 */
	public static void main(String args[])  
	{  
		/*
		 * All of the arrays.
		 */
		int[] randy = makeRandomArray(100);
		System.out.println("Random even sized array output (size of 100)");
		System.out.println(printArray(randy));
		quickSort(randy, 0, 99);
		System.out.println("Random even sized array after quickSort()");
		System.out.println(printArray(randy));
		
		int[] rand = makeRandomArray(99);
		System.out.println("Random odd sized array output (size of 99)");
		System.out.println(printArray(rand));
		quickSort(rand, 0, 98);
		System.out.println("Random odd sized array after quickSort()");
		System.out.println(printArray(rand));
		
		int[] snoopDog = makeSortedArray(100);
		System.out.println("Even sized pre-sorted array output "
				+ "(size of 100; values from least to greatest)");
		System.out.println(printArray(snoopDog));
		quickSort(snoopDog, 0, 99);
		System.out.println("Even sized pre-sorted array after quickSort()");
		System.out.println(printArray(snoopDog));
		
		int[] snoopy = makeSortedArray(99);
		System.out.println("Odd sized pre-sorted array output "
				+ "(size of 99; values from least to greatest)");
		System.out.println(printArray(snoopy));
		quickSort(snoopy, 0, 98);
		System.out.println("Odd sized pre-sorted array after quickSort()");
		System.out.println(printArray(snoopy));
		
		int[] drawrof = makeSortedArrayR(100);
		System.out.println("Even sized reverse pre-sorted array output "
				+ "(size of 100; values from greatest to least)");
		System.out.println(printArray(drawrof));
		quickSort(drawrof, 0, 99);
		System.out.println("Even sized reverse pre-sorted array after quicksort()");
		System.out.println(printArray(drawrof));
		
		int[] drawrofSmall = makeSortedArrayR(99);
		System.out.println("Odd sized reverse pre-sorted array output "
				+ "(size of 99; values from greatest to least)");
		System.out.println(printArray(drawrofSmall));
		quickSort(drawrofSmall, 0, 98);
		System.out.println("Odd sized reverse pre-sorted array after quicksort()");
		System.out.println(printArray(drawrofSmall));
		
		int[] tiny = { 1, 9 };
		System.out.println("Even sized tiny array "
				+ "(size of 2; least to greatest)");
		System.out.println(printArray(tiny));
		quickSort(tiny, 0, 1);
		System.out.println("Even sized tiny array after quickSort()");
		System.out.println(printArray(tiny));
		
		int[] reverseTiny = { 8, 2 };
		System.out.println("Even sized tiny array "
				+ "(size of 2; greatest to least)");
		System.out.println(printArray(reverseTiny));
		quickSort(reverseTiny, 0, 1);
		System.out.println("Even sized tiny array after quickSort()");
		System.out.println(printArray(reverseTiny));
		
		int[] teeny = { 5, 2, 8 };
		System.out.println("Odd sized tiny array (size of 3;)");
		System.out.println(printArray(teeny));
		quickSort(teeny, 0, 2);
		System.out.println("Odd sized tiny array after quickSort()");
		System.out.println(printArray(teeny));
		
		int[] weeny = { 3 };
		System.out.println("Single element array (size of 1;)");
		System.out.println(printArray(weeny));
		quickSort(weeny, 0, 0);
		System.out.println("Single element array afterquickSort()");
		System.out.println(printArray(weeny));
		
		/* 
		 * All of the Lists. 
		 */
		ArrayList<Comparable<Integer>> listerine = makeRandomList(100);
		System.out.println("Random List output (size of 100)");
		System.out.println(printList(listerine));
		mergeSort(listerine);
		System.out.println("Random List after mergeSort()");
		System.out.println(printList(listerine));
		listerine.add(100, -1);
		mergeSort(listerine);
		System.out.println("Random List after adding value -1 to index 100"
				+ '\n' + "to make ArrayList odd length, and mergeSorting");
		System.out.println(printList(listerine));
		
		ArrayList<Comparable<Integer>> sortedFirst = makeSortedList(100);
		System.out.println("Pre-Sorted List output "
				+ "(size of 100; least to greatest)");
		System.out.println(printList(sortedFirst));
		mergeSort(sortedFirst);
		System.out.println("Pre-Sorted List after mergeSort()");
		System.out.println(printList(sortedFirst));
		sortedFirst.add(100, -1);
		mergeSort(sortedFirst);
		System.out.println("Pre-Sorted List after adding value -1 "
				+ '\n' + "to make ArrayList odd length, and mergeSorting");
		System.out.println(printList(sortedFirst));
		
		ArrayList<Comparable<Integer>> sortedReverse = makeSortedListR(100);
		System.out.println("Reverse Pre-Sorted List output "
				+ "(size of 100; greatest to least)");
		System.out.println(printList(sortedReverse));
		mergeSort(sortedReverse);
		System.out.println("Reverse Pre-Sorted List after mergeSort()");
		System.out.println(printList(sortedReverse));
		sortedReverse.add(100, -1);
		mergeSort(sortedReverse);
		System.out.println("Reverse Pre-Sorted List after adding value -1 to index 100"
				+ '\n' + "to make ArrayList odd length, and mergeSorting");
		System.out.println(printList(sortedReverse));
		
		ArrayList<Comparable<Integer>> small = new ArrayList<Comparable<Integer>>();
		small.add(0, 3);
		small.add(1, 42);
		System.out.println("Tiny List output (size of 2; least to greatest)");
		System.out.println(printList(small));
		mergeSort(small);
		System.out.println("Tiny List output after mergeSort()");
		System.out.println(printList(small));
		small.add(2, -1);
		mergeSort(small);
		System.out.println("Tiny List after adding value -1 to index 2"
				+ '\n' + "to make ArrayList odd length, and mergeSorting");
		System.out.println(printList(small));
		
		ArrayList<Comparable<Integer>> single = new ArrayList<Comparable<Integer>>();
		single.add(0, 777);
		System.out.println("Single Integer List output");
		System.out.println(printList(single));
		mergeSort(single);
		System.out.println("Single Integer List after mergeSort()");
		System.out.println(printList(single));
	}
}
