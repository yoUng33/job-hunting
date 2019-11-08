#7. Reverse Integer
<https://leetcode.com/problems/reverse-integer/>  

Easy  

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

    Input: 123
    Output: 321
    Example 2:
    
    Input: -123
    Output: -321
    Example 3:
    
    Input: 120
    Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Related Topics: Math

Similar Questions:  
    String to Integer (atoi)[Medium]  
    Reverse Bits[Easy]  

Solution:  
注意正负和Integer的范围。用long型变量ans记录结果。因为正的处理方便，先提取正负。每次循环，拿x的末尾x%10，加到ans里： ans = ans*10 + x%10。并检查新的ans在Integer范围内(Integer.MIN_VALUE ~ Integer.MAX_VALUE)。 
O(Time): O(x.length)
```java
class Solution {
    public int reverse(int x) {
        long ans = 0;
        boolean isNeg = false;
        if(x < 0){
            x = -x;
            isNeg = true;
        }
        while(x > 0){
            ans = ans*10 + x%10;
            x/=10;
            if(!isNeg && ans > Integer.MAX_VALUE) return 0;
            else if(isNeg && -ans < Integer.MIN_VALUE) return 0;
            
        }
        if(isNeg) ans = -ans;
        return (int)ans;
    }
}
```