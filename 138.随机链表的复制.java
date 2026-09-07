/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 随机链表的复制
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;

class Solution {
    // class Node {
    // int val;
    // Node next;
    // Node random;

    // public Node(int val) {
    // this.val = val;
    // this.next = null;
    // this.random = null;
    // }
    // }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        for (var set : map.entrySet()) {
            Node random = set.getKey().random;
            Node next = set.getKey().next;
            set.getValue().random = random == null ? null : map.get(random);
            set.getValue().next = next == null ? null : map.get(next);
        }
        return map.get(head);
    }
}
// @lc code=end
