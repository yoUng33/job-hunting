# 69. Sqrt(x)
<https://leetcode.com/problems/sqrtx/>
Easy

Implement int sqrt(int x).
Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

    Input: 4
    Output: 2
Example 2:

    Input: 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since 
                the decimal part is truncated, 2 is returned.

Related Topics: Math;Binary Search
Similar Questions: 
    medium [Pow(x, n)](https://leetcode.com/problems/powx-n/)
    easy [Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)

## Solution 1:
用binary search。相当于查找最后一个不大于target的数，等于TreeMap.floorKey()。所以mid<=x/mid. 使得在数组中有很多跟目标值相同的数字存在的情况下，返回最后一个相同的数字的下一个位置。比如在数组 [2, 4, 5, 6, 9] 中查找数字3，还是返回数字4的位置，这跟上面那查找方式返回的结果相同，因为数字4在此数组中既是第一个不小于目标值3的数，也是第一个大于目标值3的数。这样返回的是第一个大于target的数，减一位就是最后一个不大于target的数。  

[LeetCode Binary Search Summary 二分搜索法小结](https://www.cnblogs.com/grandyang/p/6854825.html)
```java
class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while(left<right){
            int mid = left + (right-left)/2;
            if(x/mid >= mid) left = mid+1;
            else right = mid;
        }
        return right-1;
    }
}
```

## Solution 2:
利用牛顿迭代法，记得高数中好像讲到过这个方法，是用逼近法求方程根的神器，在这里也可以借用一下，可参见[Annie Kim's Blog的博客](https://www.cnblogs.com/AnnieKim/archive/2013/04/18/3028607.html)，因为要求x2 = n的解，令f(x)=x2-n，相当于求解f(x)=0的解，可以求出递推式如下：
  xi+1=xi - (xi2 - n) / (2xi) = xi - xi / 2 + n / (2xi) = xi / 2 + n / 2xi = (xi + n/xi) / 2

```java
class Solution{
    public int mySqrt(int x){
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
}
```