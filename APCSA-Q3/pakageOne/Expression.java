package pakageOne;

/**
 * Author: Sean Craig
 * Date: 24Jan2022
 * Description: Expression is a StackList made to have functions
 * similar to a postfix calculator.
 */
public class Expression extends StackList
{
	/**
	 * Constructor
	 */
	public Expression()
	{
		super();	
	}
	
	/**
	 * add() pulls off two ListNodes
	 * and adds a new node with its value
	 * being the sum of the values
	 */
	public void add()
	{
		push((Integer)pop()+(Integer)pop());
	}
	
	/**
	 * subtract() add() pulls off two ListNodes
	 * and adds a new node with its value
	 * being the difference between the second
	 * node value and the first
	 */
	public void subtract()
	{
		push(-1*(Integer)pop()+(Integer)pop());
	}
	
	/**
	 * multiply() pulls off two ListNodes
	 * and adds a new node with its value
	 * being the product of the values
	 */
	public void multiply()
	{
		push((Integer)pop()*(Integer)pop());
	}
	
	/**
	 * divide() pulls off two ListNodes
	 * and adds a new node with its value
	 * being the quotient between the second value
	 * and the first
	 */
	public void divide()
	{
		int thing2 = (Integer)pop();
		int thing1 = (Integer)pop();
		push(thing1/thing2);
		// 1/pop()*pop() doesn't work as it has to be double
		// and we no cast from double to int
		// and we no type 6.0 instead of 6 in main
	}
	
	/**
	 * parse(s) reads a String with a mathematical expression
	 * written in postfix and returns the end value it finds
	 */
	public Object parse(String s)
	{
		char c;
		int n = 0; // index of char in String
		int len = s.length();
		String box = ""; // temp storage for concatenating chars
	
		while(n<len)
		{
			c = s.charAt(n);
			if (Character.isDigit(c)) // isDigit checks if char is number
			{
				box += c; // add char to end of String
				n++;
			}
			else if(c == ' ')
			{
				if(box != "") // prevents issue with space after operation
				{
					// parseInt converts number in String to an Integer object
					push(Integer.parseInt(box)); 
					
					box = ""; // empty box after pushing value
					n++;
				}
				else { n++; }
			}
			else if(c == '+') { add(); n++; }
			else if(c == '-') { subtract(); n++; }
			else if(c == '*') { multiply(); n++;}
			else if(c == '/') { divide(); n++; }
		}
		return pop(); // returns answer
					  // also leaves the stack empty for
					  // the next postfix expression
	}

	/**
	 * Main method
	 */
	public static void main(String a[])
	{
		Expression x = new Expression();
		String e1 = "6 4 + 3 * 16 4 / -";
		System.out.println(x.parse(e1));
		
		String e2 = "12 25 5 1 / / * 8 7 + -";
		System.out.println(x.parse(e2));
	}
}
