package pakageOne;

public class LLTester 
{

	public static void main(String[] args) 
	{
		LinkedList llTest = new LinkedList();
	    System.out.println(llTest.isEmpty());
		String n1 = "Moses";
		String n2 = "Jesus";
		String n3 = "Mohamad";
		llTest.addFront(n1);
		llTest.addBack(n3);
		System.out.println(llTest.toString());
		System.out.println(llTest.getBack());
	
		
		
	}

}
