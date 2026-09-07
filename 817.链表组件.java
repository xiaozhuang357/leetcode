/*
 * @lc app=leetcode.cn id=817 lang=java
 *
 * [817] 链表组件
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        boolean flag = false;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            if (set.contains(cur.val)) {
                if (!flag) {
                    count++;
                    flag = true;
                }
            } else {
                flag = false;
            }
            cur = cur.next;
        }
        return count;
    }
}
// @lc code=end
