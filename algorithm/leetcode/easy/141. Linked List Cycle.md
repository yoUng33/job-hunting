# 141. Linked List Cycle
<https://leetcode.com/problems/linked-list-cycle/>
Easy

Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

 

Example 1:

    Input: head = [3,2,0,-4], pos = 1
    Output: true
    Explanation: There is a cycle in the linked list, where tail connects to the second node.

![alt text](../resources/circularlinkedlist.png)

Example 2:

    Input: head = [1,2], pos = 0
    Output: true
    Explanation: There is a cycle in the linked list, where tail connects to the first node.
![alt text](../resources/circularlinkedlist_test2.png)


Example 3:

    Input: head = [1], pos = -1
    Output: false
    Explanation: There is no cycle in the linked list.
![alt text](../resources/circularlinkedlist_test3.png)


Follow up:

Can you solve it using O(1) (i.e. constant) memory?

Related Topics: Linked List; Two Pointers
Similar Questions: 
    medium [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)
    easy [Happy Number](https://leetcode.com/problems/happy-number/)

## Two Pointer Solution:
快慢指针的经典应用。只需要设两个指针，一个每次走一步的慢指针和一个每次走两步的快指针，如果链表里有环的话，两个指针最终肯定会相遇。否则就会到达链表终点。
```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
```