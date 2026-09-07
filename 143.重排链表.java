/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        newHead = reverse(newHead);
        merge(head, newHead);
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }

    public void merge(ListNode head1, ListNode head2) {
        ListNode h1 = head1;
        ListNode h2 = head2;
        while (h1 != null && h2 != null) {
            ListNode h1_next = h1.next;
            ListNode h2_next = h2.next;

            h1.next = h2;
            h2.next = h1_next;

            h1 = h1_next;
            h2 = h2_next;
        }
    }
}
// @lc code=end
