/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null||head.next == null) {
            return head;
        }
        int count = 0;
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (slow.next != null) {
            slow = slow.next;
            count++;
        }
        if (k == count) {
            return head;
        }
        if (k > count) {
            k %= count;
        }
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        slow = dummy;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;

    }
}
// @lc code=end
