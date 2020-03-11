package jUnittest;

public class TrigonometricJunit {
	
	public static class Trig {
		
		final double PI = 3.141592653589793;
		double x = 0.0;
		
		public Trig(double x) {
			this.x = x;
		}
		
		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		//Using the Taylor's series for calculating the value of the sin function
		public double TrigFuncSin() {
			if ((x == Double.POSITIVE_INFINITY) || (x == Double.NEGATIVE_INFINITY) || (x == Double.NaN)) {
				throw new NumberFormatException("Invalid number");
			}
	        // convert x to an angle between -2 PI and 2 PI
	        x = x % (2 * PI);
	        // compute the Taylor series approximation
	        double term = 1.0;      // ith term = x^i / i!
	        double sum  = 0.0;      // sum of first i terms in taylor series

	        for (int i = 1; term != 0.0; i++) {
	            term *= (x / i);
	            if (i % 4 == 1) sum += term;
	            if (i % 4 == 3) sum -= term;
	        }
	        System.out.println(sum);
			return sum;
		}
		
//		Using the Taylor's series for calculating the value of the cos function
		public double TrigFuncCos() {
			if ((x == Double.POSITIVE_INFINITY) || (x == Double.NEGATIVE_INFINITY) || (x == Double.NaN)) { 
				throw new NumberFormatException("Invalid number");
			}
	        // convert x to an angle between -2 PI and 2 PI
	        x = x % (2 * PI);
	        // compute the Taylor series approximation
	        double term = 1.0;      // ith term = x^i / i!
	        double sum  = 0.0;      // sum of first i terms in taylor series

	        for (int i = 0; term != 0.0; i++) {
	        	if(i == 0) {
	        		sum = 1.0;
	        	} else {
	        		term *= (x / i);
	                if (i % 4 == 0) sum += term;
	                if (i % 4 == 2) sum -= term;
	        	}
	        }
	        System.out.println(sum);
			return sum;
		}
		
		public double TrigFuncTan() {
			return TrigFuncSin()/TrigFuncCos();
		}
		
		public double radtodegree(double radian) {
			return (radian*(180/PI));
		}
		
	}
	
}
