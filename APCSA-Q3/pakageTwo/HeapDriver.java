package pakageTwo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Author: Sean Craig
 * Date: 22March2022
 * Description: HeapDriver is a test class for some of Heap's methods
 * with outputs to the console demonstrating its function.
 */
public class HeapDriver 
{
	// 45, 13, 17, 77, 55, 16, 22, 44, 46, 1, 12, 23
	public static void main(String a[])
	{
		Heap testHeap = new Heap();
		String bigString = testHeap.toString()+'\n';
		System.out.println(testHeap);
		
		testHeap.add(45);
		System.out.println(testHeap);
		bigString += testHeap.toString()+'\n';
		
		testHeap.add(13);
		System.out.println(testHeap);
		bigString += testHeap.toString()+'\n';
		
		testHeap.add(17);
		System.out.println(testHeap);
		bigString += testHeap.toString()+'\n';
		
		testHeap.add(77);
		System.out.println(testHeap);
		bigString += testHeap.toString()+'\n';
		
		testHeap.add(55);
		System.out.println(testHeap);
		bigString += testHeap.toString()+'\n';
		
		testHeap.add(16);
		System.out.println(testHeap);
		bigString += testHeap.toString()+'\n';
		
		testHeap.add(22);
		System.out.println(testHeap);
		bigString += testHeap.toString()+'\n';
		
		testHeap.add(44);
		System.out.println(testHeap);
		bigString += testHeap.toString()+'\n';
		
		testHeap.add(46);
		System.out.println(testHeap);
		bigString += testHeap.toString()+'\n';
		
		testHeap.add(1);
		System.out.println(testHeap);
		bigString += testHeap.toString()+'\n';
		
		testHeap.add(12);
		System.out.println(testHeap);
		bigString += testHeap.toString()+'\n';
		
		testHeap.add(23);
		System.out.println(testHeap);
		bigString += testHeap.toString()+'\n';
		
		testHeap.removeMin();
		System.out.println(testHeap);
		bigString += testHeap.toString()+'\n';
		
		testHeap.removeMin();
		System.out.println(testHeap);
		bigString += testHeap.toString()+'\n';
		
		BufferedWriter w;
		String fileOutputName = "heapOutput.txt";
		
		try 
        {
            w = new BufferedWriter(new FileWriter(fileOutputName));
            w.write(bigString);                      
            w.close();
        }
        catch(IOException e) 
        {
            e.printStackTrace();
        }
	}
}
