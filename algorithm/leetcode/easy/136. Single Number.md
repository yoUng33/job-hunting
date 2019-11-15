# 136. Single Number
<https://leetcode.com/problems/single-number/>

Easy

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

    Input: [2,2,1]
    Output: 1
Example 2:

    Input: [4,1,2,1,2]
    Output: 4

Related Topics: Hash Table; Bit Manipulation

Similar Questions: 
    medium [Single Number II](https://leetcode.com/problems/single-number-ii/)
    medium [Single Number III](https://leetcode.com/problems/single-number-iii/)

## Solution:
根据逻辑异或的特点：1,0^a=a 2,a^b=b^a 3,a^a=0。我们把数组中所有的数字都 '异或' 起来，则每对相同的数字都会得0，然后最后剩下来的数字就是那个只有1次的数字。
```java
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int n : nums){
            ans ^= n;
        }
        return ans;
    }
}
```

