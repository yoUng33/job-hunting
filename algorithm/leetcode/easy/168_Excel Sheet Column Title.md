# 168. Excel Sheet Column Title
<https://leetcode.com/problems/excel-sheet-column-title/>
Easy

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

    Input: 1
    Output: "A"
Example 2:

    Input: 28
    Output: "AB"
Example 3:

    Input: 701
    Output: "ZY"

Related Topics: Math

Similar Questions: 
    easy [Excel Sheet Column Number](https://leetcode.com/problems/excel-sheet-column-number/)

## Solution:
从低位往高位求，每进一位，则把原数缩小26倍，再对26取余，之后减去余数，再缩小26倍，以此类推，可以求出各个位置上的字母。最后只需将整个字符串翻转一下即可。
注意能被26整除的数，如果先取余再自减会得到-1。所以先让n自减1，然后再对26取余，此时再加上字符A，就可以得到对应字符。
```java
class Solution {
    public String convertToTitle(int n) {
        if(n == 0) return "";
        return convertToTitle(--n/26) + (char)('A'+ n%26);
    }
}
```
