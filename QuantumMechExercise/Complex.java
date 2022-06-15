package poopOne;

public class Complex {
	private double real_Part;
	private double imaginary_Part;
	
	public Complex() {
		real_Part = 0;
		imaginary_Part = 0;
	}
	
	public Complex(double r, double i) {
		real_Part = r;
		imaginary_Part = i;
	}
	
	public Complex add(Complex b) {
		return new Complex(real_Part+b.getReal(), imaginary_Part+b.getImaginary());
	}
	
	public Complex multiply(Complex b) {	
		double sumR = real_Part*b.getReal();
		sumR += -1*(imaginary_Part*b.getImaginary());
		double sumI = real_Part*b.getImaginary();
		sumI += imaginary_Part*b.getReal();
		return new Complex(sumR, sumI);
	}
	
	public Complex divide(Complex b) {
		double real = (real_Part*b.getReal()+imaginary_Part*b.getImaginary())/(b.getReal()*b.getReal()+b.getImaginary()*b.getImaginary());
		double imag =  (imaginary_Part*b.getReal()-real_Part*b.getImaginary())/(b.getReal()*b.getReal()+b.getImaginary()*b.getImaginary());
		return new Complex(real, imag);
	}
	public Complex conjugate() {
		return new Complex(real_Part, -1*imaginary_Part);
	}
	
	public double modulus() {
		return Math.sqrt(real_Part*real_Part + imaginary_Part*imaginary_Part);
	}
	
	public double angle() {
		return Math.atan(imaginary_Part/real_Part);
	}
	
	public boolean equals(Complex c) {
		if(c==null || !(real_Part == c.getReal() && imaginary_Part == c.getImaginary())) { 
			return false; }
		return true;
	}
	
	public String toString() {
		String temp = ""+real_Part;
		if(imaginary_Part<0) { temp += " - " + -1*imaginary_Part + "i"; }
		else { temp += " + " + imaginary_Part + "i"; }
		return temp;
		
	}
	
	public double getReal() {
		return real_Part;
	}
	
	public double getImaginary() {
		return imaginary_Part;
	}
}
