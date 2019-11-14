# 125. Valid Palindrome
<https://leetcode.com/problems/valid-palindrome/>
Easy

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

    Input: "A man, a plan, a canal: Panama"
    Output: true
Example 2:

    Input: "race a car"
    Output: false

Related Topics: Two Pointers;String
Similar Questions: 
    easy [Palindrome Linked List](https://leetcode.com/problems/valid-palindrome/)
    easy [Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/)

## Solution:
用两个指针从两边开始检查。如果不是字母或数字，就跳过。如果不一样，返回false。

```java
class Solution {
    public boolean isPalindrome(String s) {
        int lo = 0, hi = s.length()-1;
        while(lo <= hi){
            char cLo = s.charAt(lo);
            char cHi = s.charAt(hi);
            if(!Character.isLetterOrDigit(cLo)){
                lo++;
            }else if(!Character.isLetterOrDigit(cHi)){
                hi--;
            }else{
                if(Character.toLowerCase(cLo) != Character.toLowerCase(cHi)) return false;
                lo++;
                hi--;
            }
        }
        return true;
    }
}
```