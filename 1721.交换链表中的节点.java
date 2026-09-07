/*
 * @lc app=leetcode.cn id=1721 lang=java
 *
 * [1721] 交换链表中的节点
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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode cur = head;
        int n = 1;
        while (cur.next != null) {
            if (n < k)
                slow = slow.next;
            else
                fast = fast.next;
            n++;
            cur = cur.next;
        }
        int temp = slow.val;
        slow.val = fast.val;
        fast.val = temp;
        return head;
    }
}
// @lc code=end
