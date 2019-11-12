# 100. Same Tree
<https://leetcode.com/problems/same-tree/>
Easy

Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

    Input:     1         1
            / \       / \
            2   3     2   3

            [1,2,3],   [1,2,3]

    Output: true
Example 2:

    Input:     1         1
            /           \
            2             2

            [1,2],     [1,null,2]

    Output: false
Example 3:

    Input:     1         1
            / \       / \
            2   1     1   2

            [1,2,1],   [1,1,2]

    Output: false

Related Topics: Tree;Depth-first Search

## Solution 1:
DFS来递归。首先判断p和q有null的情况。然后如果p和q的val一样，那就递归判断左右子树。
```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else return false;
    }
}
```
## Solution 2:
stackP和stackQ分别保存下个检查的node。按Preorder的顺序检查node。先检查node，然后左子树，再右子树。
```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.add(p);
        stackQ.add(q);
        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode tmpP = stackP.pop();
            TreeNode tmpQ = stackQ.pop();
            if (tmpP.val != tmpQ.val) return false;
            if (tmpP.left != null && tmpQ.left != null) {
                stackP.push(tmpP.left);
                stackQ.push(tmpQ.left);
            } else if (tmpP.left == null && tmpQ.left == null) {
            } else {
                return false;
            }
            if (tmpP.right != null && tmpQ.right != null) {
                stackP.push(tmpP.right);
                stackQ.push(tmpQ.right);
            } else if (tmpP.right == null && tmpQ.right == null) {
            } else {
                return false;
            }
        }
        if (!stackP.isEmpty() || !stackQ.isEmpty()) return false;
        return true;
    }
}
```