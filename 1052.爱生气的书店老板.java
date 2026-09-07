/*
 * @lc app=leetcode.cn id=1052 lang=java
 *
 * [1052] 爱生气的书店老板
 */

// @lc code=start
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int[] s = new int[2];
        int max = 0;
        for (int i = 0; i < customers.length; i++) {
            s[grumpy[i]] += customers[i];
            int left = i - minutes + 1;
            if (left < 0) {
                continue;
            }
            max = Math.max(max, s[1]);

            s[1] -= grumpy[left] == 1 ? customers[left] : 0;

        }

        return max+s[0];
    }
}
// @lc code=end
