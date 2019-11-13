# 101. Symmetric Tree
<https://leetcode.com/problems/symmetric-tree/>

Easy

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
``` 

But the following [1,2,2,null,3,null,3] is not:
```
    1
   / \
  2   2
   \   \
   3    3
``` 

Note:
Bonus points if you could solve it both recursively and iteratively.

Related Topics: Tree;Depth-first Search;Breadth-first Search

## Solution:
DFS递归。因为是中线对称，所以建立一个helper（）方法来对比两个node是否及其子树是否对称。递归检查左子树的左子树和右子树的右子树（最外侧）和左子树的右子树和右子树的左子树（最内侧）。
```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
        if(left == null || right == null) return left == right;
        if(left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
```