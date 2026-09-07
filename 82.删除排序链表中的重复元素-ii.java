/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(-1, head);
        ListNode dummyHead = pre;
        ListNode cur = head;
        while (cur.next != null) {
            if (pre.next.val != cur.next.val) {
                pre = pre.next == cur ? cur : pre;
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        if (pre.next != cur) {
            pre.next = cur.next;
        }
        return dummyHead.next;

    }
}
// @lc code=end
