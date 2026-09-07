/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        for (int step = 1; step < len; step <<= 1) {
            ListNode prev = dummy;
            cur = dummy.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < step && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < step && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                prev.next = merge(head1, head2);
                while (prev.next != null) {
                    prev = prev.next;
                }
                cur = next;
            }
        }
        return dummy.next;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
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
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
// @lc code=end
