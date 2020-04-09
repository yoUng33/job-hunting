# 118. Pascal's Triangle

<https://leetcode.com/problems/pascals-triangle/>

Easy 

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
![alt text](./../resources/PascalTriangleAnimated2.gif)
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:
```
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

Related Topics: Array

Similar Questions: 
    easy [Pascal's Triangle II](https://leetcode.com/problems/pascals-triangle-ii/)

## Solution:  
新一行的头尾都是1， 中间第j位是上一行的j-1和j位的数字之和。
```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        if(numRows == 0) return res;
        res.add(Arrays.asList(1));
        for(int i=0; i<numRows-1; i++){
            List<Integer> curRow = res.get(i);
            List<Integer> newRow = new ArrayList();
            for(int j=0; j<=curRow.size();j++){
                int a = 0, b = 0;
                if(j >= 1){
                    a = curRow.get(j-1);
                }
                if(j<curRow.size()){
                    b = curRow.get(j);
                }
                newRow.add(a+b);
            }
            res.add(newRow);
        }
        return res;
    }
}
```