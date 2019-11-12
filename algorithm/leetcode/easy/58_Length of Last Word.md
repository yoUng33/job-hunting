# 58. Length of Last Word
<https://leetcode.com/problems/length-of-last-word/>
Easy

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

    Input: "Hello World"
    Output: 5

## Solution 1:
注意连续空格和最后是空格的情况。从后往前找，去掉末尾空格，计算第一个非空格开始的单词。
```java
class Solution {
    public int lengthOfLastWord(String s) {
        int right = s.length() - 1, res = 0;
        while (right >= 0 && s.charAt(right) == ' ') --right;
        while (right >= 0 && s.charAt(right) != ' ' ) {
            --right; 
            ++res;
        }
        return res;
    }
}
```

## Solution 2:
用string.trim()和lastIndexOf()
```java
class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}
```