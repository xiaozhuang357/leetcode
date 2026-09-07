/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并 K 个升序链表
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

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

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);

    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        head.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
// @lc code=end
