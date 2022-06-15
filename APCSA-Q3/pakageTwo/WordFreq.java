package pakageTwo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Author: Sean Craig
 * Date: 16Feb2022
 * Description: WordFreq takes a file, reads the words or characters in close proximity
 * and reports how many of each there are.
 */
public class WordFreq 
{
	/**
	 * loadMap(m, file) sets the Map input with nodes 
	 * created out of the input file's pieces
	 */
	public static void loadMap(Map m, String file)
	{
		Scanner sc = null;   
		try 
        {
            sc = new Scanner(new BufferedReader(new FileReader(file)));
            while(sc.hasNext())
            {
    			// next() reads a word(/grouping of characters) and tokenizes it
    			String word = sc.next();
    			
    			// get the value associated with the key word
    			Integer i = (Integer)m.get(word);
    			if(i == null)
    			{
    				// put new word in the map since we've seen it once
    				m.put(word, Integer.valueOf(1));
    			}
    			else
    			{
    				// add 1 to the number of times we've seen it
    				m.put(word, Integer.valueOf(i.intValue()+1));
    			}
            }
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            if (sc != null)
                sc.close();  // regardless we need to close the scanned file.
        }           
	}
	
	/**
	 * Main method
	 */
	public static void main(String a[])
	{
		Map hash = new HashMap();
		loadMap(hash, "inFile1.txt");
		System.out.print("HashMap output for inFile1: ");
		System.out.println(hash);
		
		loadMap(hash, "inFile2.txt");
		System.out.print("HashMap output for inFile2: ");
		System.out.println(hash);
		
		loadMap(hash, "inFile3.txt");
		System.out.print("HashMap output for inFile3: ");
		System.out.println(hash);
		
		Map tree = new TreeMap();
		loadMap(tree, "inFile1.txt");
		System.out.print("TreeMap output for inFile3: ");
		System.out.println(tree);
		
		loadMap(tree, "inFile2.txt");
		System.out.print("TreeMap output for inFile3: ");
		System.out.println(tree);
		
		loadMap(tree, "inFile3.txt");
		System.out.print("TreeMap output for inFile3: ");
		System.out.println(tree);
	}
}