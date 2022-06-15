package poopOne;

public class Matrix {
	private double[][] matrix;
	
	public Matrix(int row, int col) {
		matrix = new double[row][col];
		for(int x=0; x<row; x++) {
			for(int y=0; y<col; y++) {
				matrix[x][y] = 0.0;
			}
		}
	}
	
	public Matrix(int row, int col, int range) {
		matrix = new double[row][col];
		for(int x=0; x<row; x++) {
			for(int y=0; y<col; y++) {
				matrix[x][y] = (int)(Math.random()*range+1);
			}
		}
	}
	
	
	
	public boolean canMultiply(Matrix other) {
		if(matrix==null || other==null) { return false; }
		if(matrix[0].length == other.getMatrix().length) { return true; }
		return false;
	}
	
	public Matrix multiply(Matrix other) {
		if(matrix==null || other==null || !canMultiply(other)) { return new Matrix(0, 0); }
		double[][] mat2 = other.getMatrix();
		Matrix temp = new Matrix(matrix.length, mat2[0].length);
		double tempSum = 0.0;
		for(int Rc=0; Rc<mat2[0].length; Rc++) {
			for(int Rr=0; Rr<matrix.length; Rr++) {
				for(int x=0; x<matrix[0].length; x++) {
					tempSum += (matrix[Rr][x]*mat2[x][Rc]);
				}
				temp.setMatrix(Rr, Rc, tempSum);
				tempSum = 0.0;
			}
		}
		return temp;
	}
	
	
	
	
	public double[][] getMatrix() {
		return matrix;
	}
	
	public void setMatrix(int row, int col, double val) {
		matrix[row][col] = val;
	}
	
	public String toString() {
		String temp = "";
		for(double[] row: getMatrix()) {
			for(double col: row) {
				temp += " [ " + col + " ]";
			}
			temp += '\n';
		}
		return temp;
	}
}
