/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 *
 * https://leetcode.cn/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (59.35%)
 * Likes:    1578
 * Dislikes: 0
 * Total Accepted:    964.4K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [], val = 1
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 列表中的节点数目在范围 [0, 10^4] 内
 * 1 
 * 0 
 * 
 * 
 */

// @lc code=start

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

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == val) {
                if (cur == pre) {
                    pre = pre.next;
                    head = head.next;
                } else {
                    pre.next = cur.next;
                }
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
// @lc code=end
