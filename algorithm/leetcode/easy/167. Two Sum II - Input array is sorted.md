# 167. Two Sum II - Input array is sorted
<https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/>
Easy


Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

* Your returned answers (both index1 and index2) are not zero-based.
* You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.


Related Topics: Array; Two Pointers; Binary Search
Similar Questions:
    easy [Two Sum](https://leetcode.com/problems/two-sum/)
    easy [Two Sum IV - Input is a BST](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/) 
    easy [Two Sum Less Than K](https://leetcode.com/problems/two-sum-less-than-k/)

## Two Pointer Solution:
用两个指针lo，hi分别从数组两头开始往中间遍历。如果lo和hi的数值和小于target，lo++；大于target，hi--。相等则返回lo和hi。
```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length-1;
        while(lo < hi){
            int sum = numbers[lo] + numbers[hi];
            if(target == sum) return new int[]{lo+1, hi+1};
            else if(target > sum) lo++;
            else hi--;
        }
        return null;
    }
}
```