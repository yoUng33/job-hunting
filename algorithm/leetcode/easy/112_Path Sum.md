# 112. Path Sum
<https://leetcode.com/problems/path-sum/>
Easy

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,
```
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
```
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Related Topics: Tree; Depth-first Search

Similar Questions: 
    medium [Path Sum II](https://leetcode.com/problems/path-sum-ii/)
    hard [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
    medium [Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/)
    easy [Path Sum III](https://leetcode.com/problems/path-sum-iii/)
    medium [Path Sum IV](https://leetcode.com/problems/path-sum-iv/)

## Solution:
DFS递归。利用递归检查左右子树, sum是到当前node的剩余值。如果是node为null，就返回false。如果node是叶子而且值为剩余值sum，就找到所需路径。这些是递归的终止条件。然后对左右子树进行递归，因为只要有一条路径即可，所以是 || 连接。
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}
```


## Solution:
先序遍历的迭代写法。先序遍历二叉树，左右子结点都需要加上其父结点值，这样当遍历到叶结点时，如果和 sum 相等了，那么就说明一定有一条从 root 过来的路径。注意这里不必一定要先处理右子结点，调换下顺序也是可以的，因为不论是先序遍历的根-左-右，还是根-右-左，并不会影响到找路径
```java
class Solution{
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack <TreeNode> stack = new Stack<> ();
	    stack.push(root);
	    while (!stack.isEmpty() && root != null){
	    	TreeNode cur = stack.pop() ;	
	    	if (cur.left == null && cur.right == null){	    		
	    		if (cur.val == sum ) return true ;
	    	}
	    	if (cur.right != null) {
	    		cur.right.val = cur.val + cur.right.val ;
	    		stack.push(cur.right) ;
	    	}
	    	if (cur.left != null) {
	    		cur.left.val = cur.val + cur.left.val;
	    		stack.push(cur.left);
	    	}
	    }	    
	    return false ;
	 }
}
```