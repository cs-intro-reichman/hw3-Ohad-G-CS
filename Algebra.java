// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int solution = x1;
		for (int i = 0; i < x2; i++) {
			solution++;
		}

		return solution;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int solution = x1;
		for (int i = 0; i < x2; i++) {
			solution--;
		}

		return solution;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int solution = 0;
		for (int i = 0; i < x2; i++) {
			solution = plus(solution, x1);
		}
		return solution;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int solution = x;
		if( n == 0 ) {
				return 1;
		}
		if(x == 1 || x == 0) {
				return x;
		}
		for (int p = 2; p <= n; p++) { //p reresent the חזקה
			solution = times(solution, x);
	    }
		return solution;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int n = x1;
		int count = 0;
		while (n > 0 && x2 != 0) {
		      n = minus(n, x2);
			  count++;
	    }
			if( n < 0 ) {
				n = plus(n, x2);
				count--;
			}

		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int n = x1;
		while (n > 0) {
		      n = minus(n, x2);
	        }
			if( n < 0 ) {
				n = plus(n, x2);
		    }

		return n;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int solution = 0;
		for (int j = 0; j < x; j++) {
			solution = times(j, j);
			if (solution == x) {
				return j;
			}
	    }

		return -1;
	}	  	  
}