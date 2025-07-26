/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
       ListNode prev = null; // Previous node, initially null
        ListNode curr = head; // Current node starts from the head
        while (curr != null) {
            ListNode next = curr.next; // Store next node
            curr.next = prev; // Reverse the current node's pointer
            prev = curr; // Move prev to current
            curr = next; // Move curr to next
        }
        return prev; // New head of the reversed list

    }
}