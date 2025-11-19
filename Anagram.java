/** Functions for checking if a given string is an anagram. */
public class Anagram {
    public static void main(String args[]) {
        // Tests the isAnagram function.
        System.out.println(isAnagram("silent","listen"));  // true
        System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
        System.out.println(isAnagram("Madam Curie","Radium came")); // true
        System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

        // Tests the preProcess function.
        System.out.println(preProcess("What? No way!!!"));
        
        // Tests the randomAnagram function.
        System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
        
        // Performs a stress test of randomAnagram 
        String str = "1234567";
        Boolean pass = true;
        //// 10 can be changed to much larger values, like 1000
        for (int i = 0; i < 10; i++) {
            String randomAnagram = randomAnagram(str);
            System.out.println(randomAnagram);
            pass = pass && isAnagram(str, randomAnagram);
            if (!pass) break;
        }
        System.out.println(pass ? "test passed" : "test Failed");
    }  

    // Returns true if the two given strings are anagrams, false otherwise.
    public static boolean isAnagram(String str1, String str2) {
        String strA = preProcess(str1);
        String strB = preProcess(str2); 
        
        if (strA.length() != strB.length()) {
            return false;
        }

        for (int i = 0; i < strA.length(); i++) {
            char currentChar = strA.charAt(i);
            int index = strB.indexOf(currentChar); 
            
            if (index == -1) {
                return false;
            } else {
                strB = letterRemover(strB, index); 
            }
        }
        return true;
    }
       
    // Returns a preprocessed version of the given string: all the letter characters are converted
    // to lower-case, and all the other characters are deleted, except for spaces, which are left
    // as is. For example, the string "What? No way!" becomes "whatnoway"
    public static String preProcess(String str) {
        String str1 = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                str1 = str1 + c;
            }
        }
        return str1.toLowerCase();
    } 
       
    // Returns a random anagram of the given string. The random anagram consists of the same
    // characters as the given string, re-arranged in a random order. 
    public static String randomAnagram(String str) {
        String str1 = "";
        String str2 = str;
        
        for (int i = 0; i < str.length(); i++) {
            int r = (int)(Math.random() * str2.length());
            
            str1 = str1 + str2.charAt(r);
            str2 = letterRemover(str2, r); 
        }
        return str1;
    }

    public static String letterRemover(String str, int c) {
        String str1 = "";
        for (int i = 0; i < str.length(); i++) {
            if (i != c) {
                str1 = str1 + str.charAt(i);
            }
        }
        return str1;
    }
}