#9. Palindrome Number
<https://leetcode.com/problems/palindrome-number/>

Easy

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

    Input: 121
    Output: true
    Example 2:
    
    Input: -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    Example 3:
    
    Input: 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Follow up:
Coud you solve it without converting the integer to a string?

Related Topics: Math

Similar Questions:  
    Palindrome Linked List[Easy]

##Solution: 
(x!=0 && x%10==0) 代表x以0结尾且不是0，因为整数的最高位不能是0，所以回文数的最低位也不能为0，数字0除外，所以直接返回 false。
要验证palindrome, 只要翻转后半段并和前半段相等即可。每次循环通过对 10 取余，取出最低位的数字，然后加到取出数的末尾，就是将 rev 乘以 10，再加上这个余数，这样翻转也就同时完成了，每取一个最低位数字，x都要自除以 10。这样当 rev 大于等于x的时候循环停止。
最后，因为palindrome可奇可偶。当偶数时，x == rev。当奇数时，x == rev/10，中间数是rev的末位。

```java
class Solution{
    public boolean isPalindrome(int x) {
        if(x<0 || (x != 0 && x%10 == 0))return false;
        int rev = 0;
        while(x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x == rev || x == rev/10);
    }
}
```