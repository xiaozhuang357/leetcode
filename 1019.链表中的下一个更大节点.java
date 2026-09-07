/*
 * @lc app=leetcode.cn id=1019 lang=java
 *
 * [1019] 链表中的下一个更大节点
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

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
    //     int val;
    //     ListNode next;

    //     ListNode() {
    //     }

    //     ListNode(int val) {
    //         this.val = val;
    //     }

    //     ListNode(int val, ListNode next) {
    //         this.val = val;
    //         this.next = next;
    //     }
    // }

    public int[] nextLargerNodes(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        int[] ans = new int[list.size()];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) {
            while (!q.isEmpty() && list.get(i).val > list.get(q.peek()).val) {
                ans[q.pop()] = list.get(i).val;
            }
            q.push(i);
        }
        return ans;
    }
}
// @lc code=end
