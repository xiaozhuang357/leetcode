/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */

// @lc code=start

import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

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

    // public class ListNode {
    // int val;
    // ListNode next;

    // ListNode() {
    // }

    // ListNode(int val) {
    // this.val = val;
    // }

    // ListNode(int val, ListNode next) {
    // this.val = val;
    // this.next = next;
    // }
    // }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head.next;
        ListNode lastSorted = head;
        while (cur != null) {
            if (lastSorted.val <= cur.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummy;
                while (prev.next.val <= cur.val) {
                    prev = prev.next;
                }
                lastSorted.next = cur.next;
                cur.next = prev.next;
                prev.next = cur; 
            }
            cur = lastSorted.next;
        }
        return dummy.next;
    }
}
// @lc code=end
