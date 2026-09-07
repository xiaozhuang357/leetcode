/*
 * @lc app=leetcode.cn id=1669 lang=java
 *
 * [1669] 合并两个链表
 */

// @lc code=start

import java.sql.RowId;

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode left = list1;
        ListNode right = list1;
        int i = 0;
        while (i++ < a-1)
            left = left.next;
        right = left;
        while (i++ < b+1)
            right = right.next; 
        ListNode last = list2;
        while (last.next != null)
            last = last.next;
        left.next = list2;
        last.next = right.next;            
        return list1;
    }
}
// @lc code=end
