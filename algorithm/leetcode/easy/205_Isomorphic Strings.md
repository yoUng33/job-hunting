# 205. Isomorphic Strings
<https://leetcode.com/problems/isomorphic-strings/>
Easy

Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

    Input: s = "egg", t = "add"
    Output: true
Example 2:

    Input: s = "foo", t = "bar"
    Output: false
Example 3:

    Input: s = "paper", t = "title"
    Output: true
Note:
You may assume both s and t have the same length.

Related Topics: Hash Table

Similar Questions: 
* Easy [Word Pattern](https://leetcode.com/problems/word-pattern/)


## Solution 
因为是一对一映射。需要用两个map来记录原字符串和目标字符串中字符出现的位置。根据ASCII只有256个字符的特点，用大小为256的数组来代替map。遍历原字符串，分别从源字符串和目标字符串取出一个字符，然后分别在两个数组中查找其值，若不相等，则返回 false，若相等，将其值更新为 i + 1，因为默认的值是0，所以更新值为 i + 1，这样当 i=0 时，则映射为1，如果不加1的话，那么就无法区分是否更新了。
```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sArr = new int[256];
        int[] tArr = new int[256];
        for(int i=0; i<s.length(); i++){
            if(sArr[s.charAt(i)] != tArr[t.charAt(i)]) return false;
            sArr[s.charAt(i)] = tArr[t.charAt(i)] = i+1;
        }
        return true;
    }
}
```