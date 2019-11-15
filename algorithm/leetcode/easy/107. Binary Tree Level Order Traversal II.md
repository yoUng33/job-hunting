# 107. Binary Tree Level Order Traversal II
<https://leetcode.com/problems/binary-tree-level-order-traversal-ii/>
Easy

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
```
    3
   / \
  9  20
    /  \
   15   7
```
return its bottom-up level order traversal as:
    [
        [15,7],
        [9,20],
        [3]
    ]

Related Topics: Tree; Breadth-first Search
Similar Questions:  
    medium [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
    easy [Average of Levels in Binary Tree](https://leetcode.com/problems/average-of-levels-in-binary-tree/)

## DFS Recursion Solution:
DFS递归。我们先递归左右子树，最后再插入root。这样插入时，list的size是树的高度。用指针level来记录当前高度，插入位置是倒的，所以是list.size()-level-1。

```java
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }
    
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }
}
```
## BFS Iteration Solution:
用queue来保存同一个level的node，用levelNum来记录当前level node的数量。然后遍历每一层时，把子树加入queue中作为下一层。插入完成的一层列表时要插入在头部。
```java
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if(root == null) return wrapList;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }
}
```
