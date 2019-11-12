# 83. Remove Duplicates from Sorted List  
<https://leetcode.com/problems/remove-duplicates-from-sorted-list/>
Easy

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

    Input: 1->1->2
    Output: 1->2
Example 2:

    Input: 1->1->2->3->3
    Output: 1->2->3

Related Topics: Linked List

Similar Questions: 
    medium [Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)

## Solution 1:
遍历链表。对比每个Node和Node.next的值。如果值相同，只要将Node的next跳过下一个，指向再下一个。这样遍历下来，所有重复的结点都会被跳过，留下的链表就是没有重复项的了。
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head != null && head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return dummy.next;
    }
}
```  

## Solution 2:
递归的方法来做，首先判断是否至少有两个结点，若不是的话，直接返回 head。
对 head->next 调用递归函数，并赋值给 head->next。这里可能比较晕，先看后面一句，返回的时候，head 结点先跟其身后的结点进行比较，如果值相同，那么返回后面的一个结点，当前的 head 结点就被跳过了，而如果不同的话，还是返回 head 结点。可以发现了，进行实质上的删除操作是在最后一句进行了，再来看第二句，对 head 后面的结点调用递归函数，那么就应该 suppose 返回来的链表就已经没有重复项了，此时接到 head 结点后面，在第三句的时候再来检查一下 head 是否又 duplicate 了，实际上递归一直走到了末尾结点，再不断的**回溯**回来，进行删除重复结点。

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
```