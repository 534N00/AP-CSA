package packageOne;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sean Craig
 * Date: 4Nov2021
 * Description: FavoriteBoss is made to demonstrate
 * swapping field, parameter, and local variables,
 * as well as values in an array and a list.
 * Appropriate field variables, methods, and classes were
 * made to do this.
 */
public class FavoriteBoss 
{
	
	private static int value1 = 3;
	private static int value2 = 7;
	
	/**
	 * swapValues() swaps the values of two field variables.
	 */
	private static void swapValues()
	{
		int temp = value1;
		value1 = value2;
		value2 = temp;
	}
	
	/**
	 * swapValues(Boolean a, Boolean b) swaps the values of
	 * two parameters.
	 */
	private static BossBaby swapValues(Boolean a, Boolean b)
	{
		BossBaby wah = new BossBaby(a, b);
		Boolean temp = wah.getBusiness1();
		wah.setBusiness1(wah.getBusiness2());
		wah.setBusiness2(temp);
		return wah;
	}
	
	/**
	 * localSwap() swaps the values of two local variables
	 */
	private static void localSwap()
	{
		BossPapi william = new BossPapi("william");
		BossPapi wendy = new BossPapi("wendy");
		helpSwap(william, wendy);
	}
	
	/**
	 * helpSwap() assigns Strings to four field variables
	 * to be printed out later. ( Used by localSwap() )
	 */
	private static void helpSwap(BossPapi a, BossPapi b)
	{
		String temp = a.getName();
		a.setName(b.getName());
		b.setName(temp);
	}
	
	/**
	 * swapArray() swaps the values between array slots.
	 */
	public void swapArray(int a[], int index1, int index2)
	{
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
	
	/**
	 * swapList() swaps the values between List slots.
	 */
	public void swapList(List<Integer> a, int index1, int index2)
	{
		int temp = a.get(index1);
		a.set(index1, a.get(index2));
		a.set(index2, temp);
	}
	
	/**
	 * main() method.
	 */
	public static void main(String[] args) 
	{
		String pSwapValues = "swapValues() ";
		String pSwapValuesP = "swapValues(int a, int b)";
		String pLocalSwap = "localSwap()";
		String pSwapArrayP = "swapArray(int[] a, int index1, int index2)";
		String pSwapListP = "swapList(List<Integer> a, int index1, int index2)";
		
		// swapValues() demo
		System.out.println("Method 1: " + pSwapValues);
		System.out.println("The original values are " +value1+" and " +value2);
		swapValues();
		System.out.println("The new values are " +value1+" and " +value2);
		System.out.println();
		
		// swapValues() (with parameters) demo
		System.out.println("Method 2: " + pSwapValuesP);
		Boolean par1 = false;
		Boolean par2 = true;
		System.out.println("Original Booleans are "+par1+" and "+par2);
		System.out.println(swapValues(par1, par2).toString());
		System.out.println();
		
		// localSwap() demo
		System.out.println("Method 3: " + pLocalSwap);
		localSwap();
		System.out.println("william's original name was William");
		System.out.println("wendy's origninal name was Wendy");
		System.out.println("william's new name is Wendy");
		System.out.println("wendy's new name is William");
		System.out.println();
		
		// swapArray() demo
		FavoriteBoss meinzen = new FavoriteBoss();
		System.out.println("Method 4: " + pSwapArrayP);
		int[] jackSparrow;
		jackSparrow = new int[2];
		jackSparrow[0] = 1776;
		jackSparrow[1] = 2021;
		System.out.println("Slot 0 has "+jackSparrow[0]);
		System.out.println("Slot 1 has "+jackSparrow[1]);
		meinzen.swapArray(jackSparrow, 0, 1);
		System.out.println("Slot 0 now has "+jackSparrow[0]);
		System.out.println("Slot 1 now has "+jackSparrow[1]);
		System.out.println();
		
		// swapList() demo
		System.out.println("Method 5: " + pSwapListP);
		ArrayList<Integer> buckaneer;
		buckaneer = new ArrayList<Integer>();
		int temp1 = 1;
		int temp2 = 99;
		buckaneer.add(temp1);
		buckaneer.add(temp2);
		System.out.println("List of Integers has: "+buckaneer);
		meinzen.swapList(buckaneer, 0, 1);
		System.out.println("List of Integers now has after swap: "+buckaneer);	
	}
}