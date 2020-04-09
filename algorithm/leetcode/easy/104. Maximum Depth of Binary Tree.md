# 104. Maximum Depth of Binary Tree
<https://leetcode.com/problems/maximum-depth-of-binary-tree/>
Easy

Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],
```
    3
   / \
  9  20
    /  \
   15   7
```
return its depth = 3.

Related Topics: Tree;Depth-first Search
Similar Questions: 
    easy [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)
    easy [Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)
    easy [Maximum Depth of N-ary Tree](https://leetcode.com/problems/maximum-depth-of-n-ary-tree/)

## Solution
DFS递归。新建helper()函数来记录并对比左右子树的最大深度。每次要对level+1。
```java
class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }
    
    public int helper(TreeNode node, int level){
        if(node == null) return level;
        return Math.max(helper(node.left, level+1), helper(node.right, level+1));
    }
}
```