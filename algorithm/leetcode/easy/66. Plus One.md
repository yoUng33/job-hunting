# 66. Plus One
<https://leetcode.com/problems/plus-one/>
Easy

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

    Input: [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.
Example 2:

    Input: [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.

Related Topics: Array

Similar Questions:
    medium [Multiply Strings](https://leetcode.com/problems/multiply-strings/)
    easy [Add Binary](https://leetcode.com/problems/add-binary/)
    medium [Plus One Linked List](https://leetcode.com/problems/plus-one-linked-list/)
    easy [Add to Array-Form of Integer](https://leetcode.com/problems/plus-one/)

## Solution:
注意全是9的情况。如果全是9就要新建arr。
从后往前循环，因为最后位+1，所以如果digits[i]＜９，直接+1并return。如果digits[i] == 9,则赋值为0。如果能到头，说明全是9，那就新建int[] newNumber并赋值。

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        return newNumber;
    }
}
```
