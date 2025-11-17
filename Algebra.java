// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
    public static void main(String args[]) {
        // Tests some of the operations
        System.out.println(plus(2,3)); // 2 + 3
        System.out.println(minus(7,2)); // 7 - 2
        System.out.println(minus(2,7)); // 2 - 7
        System.out.println(times(3,4)); // 3 * 4
        System.out.println(plus(2,times(4,2))); // 2 + 4 * 2
        System.out.println(pow(5,3)); // 5^3
        System.out.println(pow(3,5)); // 3^5
        System.out.println(div(12,3));  // 12 / 3    
        System.out.println(div(5,5)); // 5 / 5  
        System.out.println(div(25,7)); // 25 / 7
        System.out.println(mod(25,7)); // 25 % 7
        System.out.println(mod(120,6)); // 120 % 6    
        System.out.println(sqrt(36));
        System.out.println(sqrt(263169));
        System.out.println(sqrt(76123));
    } 

    // Returns x1 + x2
    public static int plus(int x1, int x2) {
        int solution = x1;
        int absoluteX2 = x2;

        boolean shouldDecrement = false;
        if (x2 < 0) {
            // Get absolute value of x2 (using subtraction)
            absoluteX2 = minus(0, x2); 
            shouldDecrement = true;
        }

        for (int i = 0; i < absoluteX2; i++) {
            if (shouldDecrement) {
                solution--;
            } else {
                solution++;
            }
        }
        return solution;
    }

    // Returns x1 - x2
    public static int minus(int x1, int x2) {
        // x1 - x2 is equivalent to x1 + (-x2)
        return plus(x1, times(x2, -1)); 
    }

    // Returns x1 * x2
    public static int times(int x1, int x2) {
        int solution = 0;
        
        // Determine the sign of the result
        int sign = 1;
        if (x1 < 0) {
            x1 = minus(0, x1); 
            sign = minus(0, sign); 
        }
        if (x2 < 0) {
            x2 = minus(0, x2); 
            sign = minus(0, sign);
        }

        for (int i = 0; i < x2; i++) {
            solution = plus(solution, x1);
        }
        
        // Apply the final sign
        if (sign < 0) {
            return minus(0, solution);
        }
        return solution;
    }

    // Returns x^n (for n >= 0)
    public static int pow(int x, int n) {
        if( n == 0 ) return 1;
        
        boolean resultIsNegative = false;
        if (x < 0) {
            x = minus(0, x); // Convert to positive base
            // If n is odd, the result is negative.
            if (mod(n, 2) != 0) { 
                resultIsNegative = true;
            }
        }
        
        // If x is 0 or 1, the result is x
        if(x == 1 || x == 0) return x; 
        
        int solution = x;
        for (int p = 2; p <= n; p++) { //p reresent the חזקה
            solution = times(solution, x);
        }

        if (resultIsNegative) {
            return minus(0, solution);
        }
        return solution;
    }

    // Returns the integer part of x1 / x2 
    public static int div(int x1, int x2) {
        if (x2 == 0) return 0;

        // Determine the sign of the result
        int sign = 1;
        if ((x1 < 0) ^ (x2 < 0)) { // XOR: if signs are different
            sign = minus(0, 1);
        }

        // Work with absolute values
        int absX1 = (x1 < 0) ? minus(0, x1) : x1;
        int absX2 = (x2 < 0) ? minus(0, x2) : x2;

        int n = absX1;
        int count = 0;
        while (n >= absX2) { 
            n = minus(n, absX2);
            count++;
        }
        
        // Apply the determined sign
        if (sign < 0) {
            return minus(0, count);
        }
        return count;
    }

    // Returns x1 % x2
    public static int mod(int x1, int x2) {
        if (x2 == 0) return x1; 

        // Work with absolute values
        int absX1 = (x1 < 0) ? minus(0, x1) : x1;
        int absX2 = (x2 < 0) ? minus(0, x2) : x2;

        int n = absX1;
        while (n >= absX2) {
            n = minus(n, absX2);
        }

        // Apply the correct sign (remainder takes the sign of the dividend x1)
        if (x1 < 0) {
            return minus(0, n);
        }
        return n;
    } 

    // Returns the integer part of sqrt(x) 
    public static int sqrt(int x) {
        if (x < 0) return -1;
        if (x == 0) return 0;
        if (x == 1) return 1;

        int j = 1;
        while (true) {
            int jSquared = times(j, j);

            if (jSquared == x) {
                return j;
            }
            
            // Check if j*j exceeds x, or if overflow occurred (jSquared < 0)
            if (jSquared > x || jSquared < 0) { 
                return minus(j, 1);
            }

            j++; 
        }
    }
}