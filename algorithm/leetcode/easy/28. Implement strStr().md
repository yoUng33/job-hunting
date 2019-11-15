#28. Implement strStr()
<https://leetcode.com/problems/implement-strstr/>

Easy

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

    Input: haystack = "hello", needle = "ll"
    Output: 2
Example 2:

    Input: haystack = "aaaaa", needle = "bba"
    Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

Related Topics: Two Pointers;String

Similar Questions: 
    hard[Shortest Palindrome](./../hard/214_Shortest&#32;Palindrome.md)
    easy[Repeated Substring Pattern](./../easy/459_Repeated&#32;Substring&#32;Pattern.md)

##Solution:
遍历haystack，对于每一个字符，都遍历一遍needle。然后判断假如j到达 needle 的末尾了，此时返回i；若此时 i+j 到达 haystack 的长度了，返回 -1；否则若当前对应的字符不匹配，直接跳出当前循环
```java
class Solution{
    public int strStr(String haystack, String needle) {
    for(int i=0; ; i++){
        for(int j=0; ; j++){
            if(j == needle.length()) return i;
            if(i+j == haystack.length()) return -1;
            if(needle.charAt(j) != haystack.charAt(i+j)) break;
        }
    }
}
```