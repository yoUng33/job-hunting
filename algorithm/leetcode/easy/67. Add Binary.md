# 67. Add Binary
<https://leetcode.com/problems/add-binary/>
Easy  

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

    Input: a = "11", b = "1"
    Output: "100"
Example 2:

    Input: a = "1010", b = "1011"
    Output: "10101"

Related Topics: Math;String

Similar Questions:  
    medium [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
    medium [Multiply Strings](https://leetcode.com/problems/multiply-strings/)
    easy [Plus One](https://leetcode.com/problems/plus-one/)
    easy [Add to Array-Form of Integer](https://leetcode.com/problems/add-to-array-form-of-integer/)  

## Solution:
用StringBuilder sb来保存结果的逆顺序。用int carry来记录进位，指针idxA和idxB来记录a和b的位置。注意每次循环，需要检查指针是否已经到头。然后更新carry = sum/2, 把sum%2加入sb。循环完还要检查carry。最后返回sb的逆结果。
P.S: 可以用StringBuilder.insert(0, sum%2), 这样不用最后在翻转。

```java
class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.isEmpty()) return b;
        if(b == null || b.isEmpty()) return a;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int idxA = a.length()-1;
        int idxB = b.length()-1;
        while(idxA >= 0 || idxB >= 0){
            int sum = carry;
            if(idxA >= 0) sum += a.charAt(idxA--)-'0';
            if(idxB >= 0) sum += b.charAt(idxB--)-'0';
            carry = sum/2;
            sb.append(sum%2);
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
```