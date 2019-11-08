# 21. Merge Two Sorted Lists
<https://leetcode.com/problems/merge-two-sorted-lists/>

Easy

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
    
Related Topics: Linked List

Similar Questions:
    [hard]Merge k Sorted Lists
    [easy]Merge Sorted Array
    [medium]Sort List
    [medium]Shortest Word Distance II


Solution 1: 
递归。先检查两个node的null的情况，如果一个为null，那就返回另一个。
都不为null时，对比两个node的val。对于小的node.next 和 大的node调用递归函数。将函数返回值赋给小的node.next，然后返回小的node。
```java

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        else if(l1 == null) return l2;
        else if(l2 == null) return l1;
        else{
            if(l1.val > l2.val){
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }else{
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
        }
    }
}

```
Solution 2:
循环解法。新建一个链表，然后比较两个链表中的元素值，把较小的那个链到新链表中，由于两个输入链表的长度可能不同，所以最终会有一个链表先完成插入所有元素，则直接另一个未完成的链表直接链入新链表的末尾。
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
```