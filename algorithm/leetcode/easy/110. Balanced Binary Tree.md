# 110. Balanced Binary Tree  
<https://leetcode.com/problems/balanced-binary-tree/>

Easy

Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:
```
    3
   / \
  9  20
    /  \
   15   7
```
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:
```
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```
Return false.

Related Topics: Tree;Depth-first Search

Similar Questions:  
  medium [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)  

Solution: 
新建一个获得各个点深度的函数depth()。然后对每个node检查其左右子树的高度差。
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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if(Math.abs(leftDepth-rightDepth)<=1 && isBalanced(root.left) && isBalanced(root.right)) return true;
        else return false;
    }
    
    public int depth(TreeNode node){
        if(node == null) return 0;
        return Math.max(depth(node.left), depth(node.right))+1;
    }
}
```