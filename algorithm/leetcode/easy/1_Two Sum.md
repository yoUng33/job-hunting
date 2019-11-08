1. Two Sum
<https://leetcode.com/problems/two-sum/>

Easy

Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

    Given nums = [2, 7, 11, 15], target = 9,
    
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].

Related Topics: Array; Hash Table

Similar Questions:
    3Sum[Medium]  
    4Sum[Medium]  
    Two Sum II - Input array is sorted[Easy]  
    Two Sum III - Data structure design[Easy]  
    Subarray Sum Equals K[Medium]  
    Two Sum IV - Input is a BST[Easy]
    Two Sum Less Than K[Easy]  

Solution:  
Use map to store nums and index. Check if target - nums[i] exists in the map.

```java
class Solution {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i = 0; i < numbers.length; i++) {
        if (map.containsKey(target - numbers[i])) {
            result[1] = i + 1;
            result[0] = map.get(target - numbers[i]);
            return result;
        }
        map.put(numbers[i], i + 1);
    }
    return result;
}
```
