/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
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

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int normalLength = nodes.size() / k;
        int extraCount = nodes.size() % k;
        int prev = -1;
        int bounds = k <= nodes.size() ? k : extraCount;
        for (int i = 0; i < bounds; i ++) {
            res[i] = nodes.get(prev + 1);
            prev += normalLength;
            prev += i < extraCount ? 1 : 0;
            nodes.get(prev).next = null;
        }
        return res;
    }
}
// @lc code=end
