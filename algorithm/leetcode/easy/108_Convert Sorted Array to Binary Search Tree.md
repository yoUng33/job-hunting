# 108. Convert Sorted Array to Binary Search Tree
<https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/>

Easy

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:
Given the sorted array: [-10,-3,0,5,9],
One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
```
      0
     / \
   -3   9
   /   /
 -10  5
 ```

Related Topics: Tree;Depth-first Search

Similar Questions: 
    medium [Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)

## Solution:
DFS递归。因为是binary tree，所以left < root < right。因为是有序数组，所以root是数组中点，而其左右子树是中间点分开后的左右有序数组中点。
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        TreeNode head = helper(nums, 0, nums.length-1);
        return head;
    }
    
    public TreeNode helper(int[] nums, int lo, int hi){
        if(lo > hi) return null;
        int mid = lo+(hi-lo)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, lo, mid-1);
        node.right = helper(nums, mid+1, hi);
        return node;
    }
}
```

## Solution：
It is very similar to doing a tree inorder traversal, I use three stacks - nodeStack stores the node I am going to process next, and leftIndexStack and rightIndexStack store the range where this node need to read from the nums.
```java
public class Solution {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        int len = nums.length;
        if ( len == 0 ) { return null; }
        
        // 0 as a placeholder
        TreeNode head = new TreeNode(0); 
        
        Deque<TreeNode> nodeStack       = new LinkedList<TreeNode>() {{ push(head);  }};
        Deque<Integer>  leftIndexStack  = new LinkedList<Integer>()  {{ push(0);     }};
        Deque<Integer>  rightIndexStack = new LinkedList<Integer>()  {{ push(len-1); }};
        
        while ( !nodeStack.isEmpty() ) {
            TreeNode currNode = nodeStack.pop();
            int left  = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid   = left + (right-left)/2; // avoid overflow
            currNode.val = nums[mid];
            if ( left <= mid-1 ) {
                currNode.left = new TreeNode(0);  
                nodeStack.push(currNode.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid-1);
            }
            if ( mid+1 <= right ) {
                currNode.right = new TreeNode(0);
                nodeStack.push(currNode.right);
                leftIndexStack.push(mid+1);
                rightIndexStack.push(right);
            }
        }
        return head;
    }

}
```
