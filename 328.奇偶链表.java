/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
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

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        ListNode oddHead = odd;
        ListNode even = new ListNode();
        ListNode evenHead = even;
        boolean flag = false;
        while (head != null) {
            if (flag) {
                evenHead.next = head;
                evenHead = evenHead.next;
                flag = false;
            } else {
                oddHead.next = head;
                oddHead = oddHead.next;
                flag = true;
            }
            head = head.next;
        }
        evenHead.next = null;
        oddHead.next = even.next;
        return odd.next;
    }
}
// @lc code=end
