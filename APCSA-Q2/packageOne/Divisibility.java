package packageOne;

/**
 * Author: Sean Craig
 * Date: 15Oct2021
 * Description: Divisibility can read a text file with 4 lines of ints.
 * There are methods to find the GCF of two ints, and the LCM of two ints.
 * The main method is for using the other methods.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Divisibility 
{
	// makes a String with the name of the file to be read
	private static String fileInputName  = "intFileIn.txt";
	
	// declares private static field variables to store the read ints
	private static int w, x, y, z;
	
	/**
	 * readInts() reads the four ints in intFileIn.txt and saves them
	 */
	public static void readInts() throws Exception
	{
		Scanner sc = new Scanner(new BufferedReader(new FileReader(fileInputName)));
            while (sc.hasNextLine()) 
            {           
                // for reading integers
                w = sc.nextInt();
                x = sc.nextInt();
                y = sc.nextInt();
                z = sc.nextInt();
            }
        sc.close();
    }
	
	/**
	 * gCFFinder() takes two specified ints and finds the GCF between them 
	 */
	public static int gCFFinder(int num1, int num2)
	{
		for (int i = num1 ; i>1; i--)
		{
			// if the remainder of both num1 and num2 is 0...
			if ((num1%i) == 0  && ((num2%i) == 0))
			{
				// ...then the current i is a factor
				return i;
			}
		}
		// if there is no other common factor, return 1 as 1 is always a factor
		return 1;
	}
	
	/**
	 * lCMFinder() takes two specified ints and finds the LCM between them 
	 */
	public static int lCMFinder(int num1, int num2)
	{
		int possibleLCM = num1;
		
		// loops until possibleLCM reaches guarenteed multiple
		while (possibleLCM < num1*num2)
		{
			// if possibleLCM is perfectly divisible by num2,
			// then it is the LCM because it is also divisible by num1
			if ((possibleLCM%num2) == 0)
			{
				return possibleLCM;
			}
			// possibleLCM increases by num1, so it is always a multitple of num1
			possibleLCM += num1;
		}
		// guarenteed multiple
		return num1*num2;
	}

	/**
	 * main() method
	 */
	public static void main(String args[]) throws Exception
	{
		readInts();
		System.out.println("The GCF of " + w + " and " + x + " is " + gCFFinder(w,x) + ".");
		System.out.println("The LCM of " + y + " and " + z + " is " + lCMFinder(y,z) + ".");
	}
}