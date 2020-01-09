package org.java.examples;


public class Palindrome {
   
   public static void main(String[] args) {
      if(isPalindrome( "abba" )) {
         System.out.println("The string is a palindrome");
      } else {
         System.out.println("The string is not a palindrome");
      }
      
   }

   /**
    * Returns true if a string is a palindrome
    */
   public static boolean isPalindrome(String str) {    
      int n = str.length();
      for( int i = 0; i < n/2; i++ )
          if (str.charAt(i) != str.charAt(n-i-1)) return false;
      return true;    
  }
}
