package packageOne;

/** Example of Java File I/O using Scanner class */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;          

public class FileTester 
{           
     public static void main(String[] args) 
     {           
          String fileInputName  = "testReadData.txt";
          String fileOutputName = "testWriteData.txt";
          Scanner sc = null;           
          try 
          {
              sc = new Scanner(new BufferedReader(new FileReader(fileInputName)));
              while (sc.hasNextLine()) 
              {           
 
                  // for reading Strings
            	  for (int i=0; i<5; i++)
            	  {
                  String line = sc.nextLine();
                  System.out.println("read string = "+line);     
            	  }
                  
                  // for reading integers
                  int i = sc.nextInt();
                  System.out.println("read integer = "+i);
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
          
          // printing output to a file
          BufferedWriter out = null;
          try 
          {
              out = new BufferedWriter(new FileWriter(fileOutputName));
              out.write(Double.toString(3.141592)+'\n'); //added an end-of-line character
              out.write(Integer.toString(7));            // so that this line is outputted
              out.write("help");                         // on the next line.
              out.close();
          }
          catch(IOException e) 
          {
              e.printStackTrace();
          }
      }
}