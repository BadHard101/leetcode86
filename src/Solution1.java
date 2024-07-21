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
class Solution1 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode lastLess = new ListNode(-101);
        ListNode lastMore = new ListNode(-101);
        ListNode firstMore = new ListNode(-101);
        ListNode root = new ListNode(-101);
        
        while (head.next != null) {
            if (head.val >= x) {
                if (firstMore.val == -101) firstMore = head;
                if (lastMore.val != -101) lastMore.next = head;
                lastMore = head;
            } else {
                if (root.next == null) root.next = head;
                if (lastLess.val != -101) lastLess.next = head;
                lastLess = head;
            }
            head = head.next;
        }
        if (head.val >= x) {
            if (firstMore.val == -101) firstMore = head;
            if (lastMore.val != -101) lastMore.next = head;
            lastMore = head;
        } else {
            if (root.next == null) root.next = head;
            if (lastLess.val != -101) lastLess.next = head;
            lastLess = head;
        }
            

        if (lastLess.val == -101) root.next = firstMore;
        if (firstMore.val != -101 && lastLess.val != -101) lastLess.next = firstMore;
        if (lastMore.val != -101) lastMore.next = null;

        return root.next;
    }
}