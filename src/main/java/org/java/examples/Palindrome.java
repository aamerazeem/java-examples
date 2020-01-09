package org.java.examples;


public class Palindrome {
   
   public static void main(String[] args) {
      String input = "racecar";
      if(isPalindromeApproach1( input ) && isPalindromeApproach2( input ) && isPalindromeApproach3( input )) {
         System.out.println("The string is a palindrome");
      } else {
         System.out.println("The string is not a palindrome");
      }
      
   }

   /**
    * Returns true if a string is a palindrome
    */
   public static boolean isPalindromeApproach1(String str) {    
      int n = str.length();
      for( int i = 0; i < n/2; i++ )
          if (str.charAt(i) != str.charAt(n-i-1)) return false;
      return true;    
  }
   
   /**
    * Check recursively if a string is a palindrome
    * @param str
    * @return
    */
   public static boolean isPalindromeApproach2(String str) {    
      if(str.length() == 0 || str.length() == 1)
         return true; 
     if(str.charAt(0) == str.charAt(str.length()-1))
         // check for first and last char of String:
         // if they are same then do the same thing for a substring
         // with first and last char removed. and carry on this
         // until you string completes or condition fails
         return isPalindromeApproach2(str.substring(1, str.length()-1));

     return false;    
  }
   
   public static boolean isPalindromeApproach3(String str) {
       int i = 0, j = str.length() - 1; 
       while (i < j) { 
           if (str.charAt(i) != str.charAt(j)) 
               return false; 
           i++; 
           j--; 
       } 
       return true; 
   } 
}
