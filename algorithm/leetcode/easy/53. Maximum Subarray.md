# 53. Maximum Subarray
<https://leetcode.com/problems/maximum-subarray/>
Easy  

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

Related Topics: Array; Divide and Conquer; Dynamic Programming
Similar Questions:
    easy [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
    medium [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)
    easy [Degree of an Array](https://leetcode.com/problems/degree-of-an-array/)
    medium [Longest Turbulent Subarray](https://leetcode.com/problems/longest-turbulent-subarray/)

Solution 1:
从左开始遍历数组。如果之前的sum是负的就清空。否则就加上当前值并更新当前max: maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + A[i]。
```java
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int curMax = nums[0];
        int max = curMax;
        for(int i = 1; i<nums.length; i++){
            curMax = (curMax>0? curMax : 0) + nums[i];
            max = Math.max(curMax, max);
        }
        return max;
    }
}
```

Solution 2:
Divide and Conquer Approach。这个分治法的思想就类似于二分搜索法，需要把数组一分为二，分别找出左边和右边的最大子数组之和，然后还要从中间开始向左右分别扫描，求出的最大值分别和左右两边得出的最大值相比较取最大的那一个。
```java
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1);
    }
    public int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = left + (right - left) / 2;
        int lmax = helper(nums, left, mid - 1);
        int rmax = helper(nums, mid + 1, right);
        int mmax = nums[mid], t = mmax;
        for (int i = mid - 1; i >= left; --i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        t = mmax;
        for (int i = mid + 1; i <= right; ++i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }
}
```