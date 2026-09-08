/*
 * @lc app=leetcode.cn id=2106 lang=java
 *
 * [2106] 摘水果
 */

// @lc code=start
class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0;
        int ans = 0;
        int cnt = 0;
        for (int right = 0; right < fruits.length; right++) {
            // 右端点进入窗口
            cnt += fruits[right][1];
            while (left < fruits.length && steps(fruits[left][0], fruits[right][0], startPos) > k) {
                cnt -= fruits[left][1];
                left++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    private int steps(int left, int right, int startPos) {
        if (startPos <= left) {
            return right - startPos;
        }
        if (startPos >= right) {
            return startPos - left;
        }
        return Math.min(startPos - left, right - startPos) + right - left;
    }
}
// @lc code=end
