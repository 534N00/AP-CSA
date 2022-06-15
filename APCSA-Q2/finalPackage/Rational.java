package finalPackage;

public class Rational {
	
	private int numerator;
	private int denominator;
	
	public Rational(int n, int d) {
		numerator = n;
		denominator = d;
	}
	
	public int getNume() {
		return numerator;
	}
	
	public void setNume(int n) {
		numerator = n;
	}

	
	public int getDenom() {
		return denominator;
	}
	
	public void setDenom(int d) {
		denominator = d;
	}
	
	public static int gCFFinder(int num1, int num2) {
		if (num1 < num2) {
			for (int i = num1 ; i>1; i--) {
				// if the remainder of both num1 and num2 is 0...
				if ((num1%i) == 0  && (num2%i) == 0) {
					// ...then the current i is a factor
					return i;
				}
			}
		}
		else {
			for (int i = num2 ; i>1; i--) {
				// if the remainder of both num1 and num2 is 0...
				if ((num2%i) == 0  && (num1%i) == 0) {
					// ...then the current i is a factor
					return i;
				}
			}
		}
		// if there is no other common factor, return 1 as 1 is always a factor
		return 1;
	}
	
	public Rational plus(Rational other) {
		int numerator = this.getNume() * other.getDenom();
		int denominator = this.getDenom() * other.getDenom();
		return new Rational(numerator, denominator);
	}
	
	public Rational multiply(Rational other) {
		return new Rational(this.getNume() * other.getNume(), this.getDenom() * other.getDenom());
	}
	
	public Rational divide(Rational b) {
		return this.multiply(reciprocal(b));
	}
	
	public static Rational reciprocal(Rational a) {
		Rational temp = new Rational(a.getDenom(), a.getNume());
		return temp;
	}
	
	public static String toString(Rational a) {
		String temp = a.getNume() + "/" + a.getDenom();
		return temp;
	}
	
	public static void main(String a[]) {
		Rational test1 = new Rational(5, 7);
		System.out.println(toString(test1));
		
		Rational test2 = new Rational(2, 9);
		System.out.println(toString(test2));
		test1 = test1.divide(test2);
		System.out.println(toString(test1));
		test1 = reciprocal(test1);
		System.out.println(toString(test1));
		
		
	}
}
