package packageOne;

/** Example of Java console I/O using Scanner class */

import java.util.Scanner;

class IOexample
{
   public static void main(String argv[])
   {
      String s;
      int    i;
      double d;
      boolean b;

      Scanner input = new Scanner (System.in);
	  
      // Read a string
      System.out.print("Enter a string without spaces: ");
      s = input.nextLine();

      // Read an integer
      System.out.print("Enter an int: ");
      i = input.nextInt();

      // Read a double
      System.out.print("Enter a double: ");
      d = input.nextDouble();

      System.out.print("enter bool");
      b = input.nextBoolean();
      
      // Print out results
      System.out.println("The string is: " + s);
      System.out.println("The integer is: " + i);
      System.out.println("The double is: " + d);
      System.out.println("The boolean is: " + b);
   }  // end main
}  // end IOexample
