# 70. Climbing Stairs
<https://leetcode.com/problems/climbing-stairs/>
Easy

You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Note: Given n will be a positive integer.

Example 1:

    Input: 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
Example 2:

    Input: 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step

Related Topics: Dynamic Programming  

Similar Questions: 
    easy [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)
    easy [Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)
    easy [N-th Tribonacci Number](https://leetcode.com/problems/n-th-tribonacci-number/)

## Solution 1:
Dyanmic Programming。类似于fibonacci数列。因为每次只能爬1或2步，所以爬到第n层的方法从第n-1层爬1步或者从第n-2层爬2步。所以状态转换公式是dp[n] = dp[n-1] + dp[n-2]。因为最后一步不一样，所以dp[n-1]和dp[n-2]不会有重复的方法。
因为只需要记录第n-1和第n-2层，所以只需要用两个变量one_step_before 和 two_step_before。先初始化前2层，再循环计算。

```java
class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int one_step_before = 2;
        int two_step_before = 1;
        int ans = 0;
        for(int i = 3; i<=n; i++){
            ans = one_step_before + two_step_before;
            two_step_before = one_step_before;
            one_step_before = ans;
        }
        return ans;
    }
}
```

## Solution 2：
其实斐波那契数列是可以求出通项公式的，推理的过程请参见[知乎上的这个贴子](https://zhuanlan.zhihu.com/p/26679684)，那么有了通项公式后，直接在常数级的时间复杂度范围内就可以求出结果了。

```java
public class Solution {
    public int climbStairs(int n) {
        double root5 = Math.sqrt(5);
        double res =  (1 / root5) * (Math.pow((1 + root5) / 2, n + 1) - Math.pow((1 - root5) / 2, n + 1));
        return (int)res;
    }
}
```