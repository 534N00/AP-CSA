package packageOne;

/**
 * Author: Sean Craig
 * Date: 23Oct2021
 * Description: TimeTester measure the amount of time it takes 
 * (in nanoseconds) for different computations to be done.
 * Those computations involve generating an array 
 * (pre-sorted or random), Bubble Sorting the array, 
 * and Binary Searching for a target in the array.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class TimeTester 
{
	private static int nums[];
	private static int size = 10000000; // 10 mil
	private static int target;
	
	/**
	 * Creates a pre-sorted array of sequential integers, 
	 * of a particular size
	 */
	public static void generateSortedArray()
	{
		nums = new int[size];
		for (int i=0; i<size; i++)
		{
			nums[i] = i;
		}
	}
	
	/**
	 * Creates an array of random integers,
	 * with a particular size
	 */
	public static void generateRandomArray()
	{
		nums = new int[size];
		for (int i=0; i<size; i++)
		{
			nums[i] = (int) (Math.random()*size);
		}
	}

	/**
	 * Bubble Sorts an array
	 */
	public static void bubbleSort()
	{
		for (int i=0; i<nums.length; i++)
		{
			for (int j=0; j<nums.length-1; j++)
			{
				int temp = nums[j];
				nums[j] = nums[j+1];
				nums[j+1] = temp;
			}
		}
	}
	
	/**
	 * Reads the file to get an integer target
	 */
	public static void getTarget() throws Exception
	{
		Scanner sc 
			= new Scanner(new BufferedReader(new FileReader("data.txt")));
        target = sc.nextInt();  
	}
	
	/**
	 * Binary Searches an array to see if the target integer is present,
	 * returning true or false
	 */
	public static boolean binarySearch()
	{
		int left = 0, right = nums.length, middle = (left+right)/2;
		boolean found = false;
		while ((!found) && (left <= right))
		{
			if (nums[middle] == target)
			{
				found = true;
			}
			else
			{
				if (target < nums[middle])
				{
					right = middle-1;
				}
				else
				{
					left = middle+1;
				}
				middle = (left + right)/2;
			}
		}
		return found;
	}
	
	/**
	 * Measures and returns the time it takes 
	 * to generate a pre-sorted array
	 */
	public static long testMakerS()
	{
		long startTime = System.nanoTime();
		generateSortedArray();
		long endTime = System.nanoTime();
		return endTime-startTime;
	}
	
	/**
	 * Measures and returns the time it takes
	 * to generate an array with random integers
	 */
	public static long testMakerR()
	{
		long startTime = System.nanoTime();
		generateRandomArray();
		long endTime = System.nanoTime();
		return endTime-startTime;
	}
	
	/**
	 * Measures and returns the time it takes
	 * to Bubble Sort a pre-made array
	 */
	public static long testBubble()
	{
		long startTime = System.nanoTime();
		bubbleSort();
		long endTime = System.nanoTime();
		return endTime-startTime;
	}
	
	/**
	 * Measures and returns the time it takes
	 * to Binary Search a pre-made array
	 */
	public static long testBinarySearch() throws Exception
	{
		generateSortedArray();
		getTarget();
		long startTime = System.nanoTime();
		binarySearch();
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
			
	/**
	 * Main method
	 */
	public static void main(String[] a) throws Exception
	{
		// for generateArray
		//*
		long t1s = testMakerS();
		long t1r = testMakerR();
		size*=10;
		long t2s = testMakerS();
		long t2r = testMakerR();
		System.out.println(t2s/t1s);
		System.out.println(t2r/t1r);
		//*/
		
		// for sort
		//*
		size = 10000; // size = 10,000
		generateRandomArray();
		long t1sort = testBubble();
		System.out.println(t1sort);
		
		size*=10; // size = 100,000
		generateRandomArray();
		long t2sort = testBubble();
		System.out.println(t2sort);
		
		System.out.println("Bubble Sort ratio: " + t2sort/t1sort);
		//*/
		
		// for search
		//*
		size = 10000000; // size = 10,000,000
		generateSortedArray();
		double t1search = testBinarySearch();
		System.out.println(t1search);
		
		size*=10; // size = 100,000,000
		generateSortedArray();
		double t2search = testBinarySearch();
		System.out.println(t2search);
		double timeRatio = t2search/t1search;
		double dbblRatio = Math.log(timeRatio)/Math.log(2);
		
		System.out.println("Binary Search ratios: " + dbblRatio);
		//*/
	}
}
	
	/*
	I. For generateRandomArray():
	 	i) n = 10000000 (10 million) for both
	 	ii) pre-sorted: 35,092,600 nanoseconds
	 		random: 280,265,900 nanoseconds
	 	iii) done (size = 100 million)
	 	iv) pre-sorted: 334,037,200 nanoseconds
	 		random: 2,546,315,400 nanoseconds
	 	v) The ratio approximately 10 for both t2/t1.
	 	   The when n is multiplied by 10, O(n) is also multiplied by 10,
	 	   therefore 10 serves as the coefficient to the algorithm O(n) = n.
	 	
	II. For sort method:
	 	i) n = 10,000. O(n) = 100,000,000
	 	ii) t1 = 64,278,200 nanoseconds
	 	iii) done (size = 100,000)
	 	iv) t2 = 7,033,887,700 nanoseconds
	 	v) t2/t1 is about 109 (should be 100). O(n) = n*n.
	 	   When size is multiplied by 10, O(n) = 10*10 times larger
	 	
	III. For search method:
	 	i) n =  10,000,000. O(n) = logBASE2(n) = 23
	 	ii) t1search = 4900 nanoseconds
	 	iii) done (size = 100,000,000)
	 	iv) t2search = 6800 nanoseconds
	 	v) The ratio between t2search and t1search is about 0.2679.
	 	   (logBASE2(t2search/t1search))
	 	   The ratio is should have been is about 3.3.
	 	   (logBASE2(100 million/10 million)

	IV. Did the time match the "Big-Oh" calculations?
		constructing: yes
		sorting: yes
		searching: Not exactly
	 	
	V. Any discrepancies between O(n) theory and what was found?
	   For Binary Search, the ratio value was not as close as I
	   would have liked because with sizes as small as what
	   I am able to use (due to memory restriction), the nanotime 
	   is too low to get a more accurate ratio.
	 */