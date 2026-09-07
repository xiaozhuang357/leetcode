/*
 * @lc app=leetcode.cn id=2379 lang=java
 *
 * [2379] 得到 K 个黑块的最少涂色次数
 */

// @lc code=start
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int max = 0;
        int currNum = 0;
        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'B') {
                currNum++;
            }
            if (i < k) {
                max = currNum;
                continue;
            }
            if (blocks.charAt(i - k) == 'B') {
                currNum--;
            }
            max = Math.max(max, currNum);
        }
        return k - max;
    }
}
// @lc code=end
