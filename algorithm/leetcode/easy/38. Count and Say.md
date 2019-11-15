# 38. Count and Say
<https://leetcode.com/problems/count-and-say/>
Easy

The count-and-say sequence is the sequence of integers with the first five terms as following:

    1.     1
    2.     11
    3.     21
    4.     1211
    5.     111221

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

    Input: 1
    Output: "1"

Example 2:

    Input: 4
    Output: "1211"

Related Topics: String

Similar Questions:
    medium [Encode and Decode Strings]()
    easy [String Compression](./../easy/443_String&#32;Compression.md)

Solution:

```java
class Solution{
    public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder("1");
        for(int i=2; i<=n; i++){
            char[] s = curr.toString().toCharArray();
            curr = new StringBuilder();
            int j = 1;
            int count = 1;
            for(; j<s.length; j++){
                if(s[j] == s[j-1]){
                    count++;
                }else{
                    curr.append(String.valueOf(count)).append(s[j-1]);
                    count = 1;
                }
            }
            curr.append(String.valueOf(count)).append(s[j-1]);
        }
        return curr.toString();
    }
}
```
