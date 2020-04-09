# 121. Best Time to Buy and Sell Stock 

<https://leetcode.com/problems/best-time-to-buy-and-sell-stock/>

Easy

Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Note that you cannot sell a stock before you buy one.

Example 1:

    Input: [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
                Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

    Input: [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transaction is done, i.e. max profit = 0.


Related Topics: Array; Dynamic Programming
Similar Questions: 
    easy [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
    easy [Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
    hard [Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)
    hard [Best Time to Buy and Sell Stock IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)
    medium [Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)

## Solution:
因为只允许交易一次，所以就是找数组中最大差值。minPrice记录当前为止最小的数，max记录最大差值。如果当前prices[i]大于minPrice，那对比max并更新。否则更新minPrice。
```java
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int max = 0, minPrice = prices[0];
        for(int i = 1; i<prices.length; i++){
            if(prices[i] > minPrice) {
                max = Math.max(max, prices[i]-minPrice);
            }else{
                minPrice = prices[i];
            }
        }
        return max;
    }
}
```
