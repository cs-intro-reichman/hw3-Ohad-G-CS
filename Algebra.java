public class Algebra {

    // Helper: מבצע היפוך סימן (0 - x) באמצעות לולאות בסיסיות בלבד, שובר את הרקורסיה.
    private static int negate_base(int x) {
        int solution = 0;
        int counter = x;
        
        if (x >= 0) {
            while (counter > 0) {
                solution--;
                counter--;
            }
        } else { // x < 0
            while (counter < 0) {
                solution++;
                counter++;
            }
        }
        return solution;
    }

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
        int absoluteX2;

        boolean shouldDecrement = false;
        if (x2 < 0) {
            absoluteX2 = negate_base(x2); // משתמש בפונקציית בסיס
            shouldDecrement = true;
        } else {
            absoluteX2 = x2;
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
        int solution = x1;
        int absoluteX2;

        boolean shouldIncrement = false;
        if (x2 < 0) {
            absoluteX2 = negate_base(x2); // משתמש בפונקציית בסיס
            shouldIncrement = true;
        } else {
            absoluteX2 = x2;
        }

        for (int i = 0; i < absoluteX2; i++) {
            if (shouldIncrement) {
                solution++;
            } else {
                solution--;
            }
        }
        return solution;
    }

    // Returns x1 * x2
    public static int times(int x1, int x2) {
        int solution = 0;
        
        int sign = 1;
        if (x1 < 0) {
            x1 = negate_base(x1); // משתמש בפונקציית בסיס
            sign = negate_base(sign); 
        }
        if (x2 < 0) {
            x2 = negate_base(x2); // משתמש בפונקציית בסיס
            sign = negate_base(sign);
        }

        for (int i = 0; i < x2; i++) {
            solution = plus(solution, x1);
        }
        
        if (sign < 0) {
            return negate_base(solution);
        }
        return solution;
    }

    // Returns x^n (for n >= 0)
    public static int pow(int x, int n) {
        if( n == 0 ) return 1;
        
        boolean resultIsNegative = false;
        if (x < 0) {
            x = negate_base(x);
            if (mod(n, 2) != 0) { 
                resultIsNegative = true;
            }
        }
        
        if(x == 1 || x == 0) return x; 
        
        int solution = x;
        for (int p = 2; p <= n; p++) {
            solution = times(solution, x);
        }

        if (resultIsNegative) {
            return negate_base(solution);
        }
        return solution;
    }

    // Returns the integer part of x1 / x2 
    public static int div(int x1, int x2) {
        if (x2 == 0) return 0;

        int sign = 1;
        if ((x1 < 0) ^ (x2 < 0)) {
            sign = negate_base(1);
        }

        int absX1 = (x1 < 0) ? negate_base(x1) : x1;
        int absX2 = (x2 < 0) ? negate_base(x2) : x2;

        int n = absX1;
        int count = 0;
        while (n >= absX2) { 
            n = minus(n, absX2);
            count++;
        }
        
        if (sign < 0) {
            return negate_base(count);
        }
        return count;
    }

    // Returns x1 % x2
    public static int mod(int x1, int x2) {
        if (x2 == 0) return x1; 

        int absX1 = (x1 < 0) ? negate_base(x1) : x1;
        int absX2 = (x2 < 0) ? negate_base(x2) : x2;

        int n = absX1;
        while (n >= absX2) {
            n = minus(n, absX2);
        }

        if (x1 < 0) {
            return negate_base(n);
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
            
            if (jSquared > x || jSquared < 0) { 
                return minus(j, 1);
            }

            j++; 
        }
    }
}