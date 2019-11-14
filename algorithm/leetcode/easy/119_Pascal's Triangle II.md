# 119. Pascal's Triangle II

<https://leetcode.com/problems/pascals-triangle-ii/>

Easy

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
Note that the row index starts from 0.
![alt text](./../resources/PascalTriangleAnimated2.gif)
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

    Input: 3
    Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?

Related Topics: Array

Similar Questions: 
    easy [Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)


## Solution:  
为了达到O(k) space， 需要用一个list来记录当前和下个组合。因为新一行的头尾都是1， 中间第j位是上一行的j-1和j位的数字之和。所以我们从后往前，避免更新j不会影响下一步更新。每个循环在末尾添加1，然后更新除第一位以外的值。

```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ansList = new ArrayList();
        for(int i = 0; i<=rowIndex; i++){
            ansList.add(1);
            for(int j = i-1; j>0; j--){
                ansList.set(j, ansList.get(j-1) + ansList.get(j));
            }
        }
        return ansList;
    }
}
```