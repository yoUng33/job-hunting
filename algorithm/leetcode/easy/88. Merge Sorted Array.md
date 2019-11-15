# 88. Merge Sorted Array
<https://leetcode.com/problems/merge-sorted-array/>
Easy

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
Note:
The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

    Input:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3

    Output: [1,2,2,3,5,6]

Related Topics: Array;Two Pointers

Similar Questions:  
    easy [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
    easy [Squares of a Sorted Array](https://leetcode.com/problems/merge-sorted-array/)
    medium [Interval List Intersections](https://leetcode.com/problems/interval-list-intersections/)  



## Solution:
因为给了m和n，所以知道混合之后数组的大小。从nums1和nums2的末尾开始比较，把较大的数加入混合后的位置m+n-1，然后较大数的指针往前移一位。如果m到头了，那就把nums2剩余的直接复制到nums1对应位置上。如果n到头了，则结束循环。

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m>0 || n>0){
            if(m<=0){
                nums1[n-1] = nums2[n-1];
                n--;
                continue;
            }
            if(n<=0) break;
            if(nums1[m-1]>nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
    }
}
```