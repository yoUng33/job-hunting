#35. Search Insert Position

Easy

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

    Input: [1,3,5,6], 5
    Output: 2
Example 2:

    Input: [1,3,5,6], 2
    Output: 1
Example 3:

    Input: [1,3,5,6], 7
    Output: 4
Example 4:

    Input: [1,3,5,6], 0
    Output: 0

Related Topics: Array;Binary Search

Similar Questions:
    easy [First Bad Version](./../easy/278_First&#32;Bad&#32;Version.md)

##Solution:
Binary Search。因为如果没找到，要返回第一个不小于target的数. 因为target未必在nums中，或者有多个同样值的，所以nums[mid] == target 这条判断语句就没有必要存在。最后返回的就是hi。
```java
class Solution{
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return hi;
    }
}
```

## Note
https://github.com/grandyang/leetcode/issues/35

[LeetCode Binary Search Summary 二分搜索法小结](https://www.cnblogs.com/grandyang/p/6854825.html)