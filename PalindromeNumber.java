//Given an integer x, return true if x is a palindrome, and false otherwise.
//Explanation: 121 reads as 121 from left to right and from right to left.

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        boolean isPalindromic = true;
        String str = String.valueOf(x);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                isPalindromic = false;
            }
        }
       return isPalindromic;
    }
}
