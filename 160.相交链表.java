/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pNode1 = headA;
        ListNode pNode2 = headB;
        while (pNode1 != pNode2) {
            pNode1 = pNode1 == null ? headB : pNode1.next;
            pNode2 = pNode2 == null ? headA : pNode2.next;
        }
        return pNode1;
    }
}
// @lc code=end
