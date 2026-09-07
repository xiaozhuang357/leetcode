/*
 * @lc app=leetcode.cn id=430 lang=java
 *
 * [430] 扁平化多级双向链表
 */

// @lc code=start
/*
// Definition for a Node.

*/
class Solution {
    public Node flatten(Node head) {
        for (Node d = head; d != null; d = d.next) {
            if (d.child != null) {
                Node child = d.child;
                Node tmp = d.next;
                d.child = null;
                d.next = child;
                child.prev = d;
                Node last = d;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = tmp;
                if (tmp != null) {
                    tmp.prev = last;
                }
            }
        }
        return head;
    }
}
// @lc code=end
