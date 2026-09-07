/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] 水果成篮
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        int[] choice = new int[2];
        choice[0] = -1;
        choice[1] = -1;
        int left = 0;
        int right = 0;
        int ans = 0;
        int n = fruits.length;
        for (; right < n; right++) {
            if (choice[0] == -1 || choice[1] == -1) {
                if (choice[0] == -1) {
                    choice[0] = fruits[right];
                } else if (choice[0] != fruits[right]) {
                    choice[1] = fruits[right];
                }
            }
            if (fruits[right] != choice[0] && fruits[right] != choice[1]) {
                int last = right - 1;
                left = last;
                while (fruits[left] == fruits[last]) {
                    left--;
                }
                choice[0] = choice[0] == fruits[last] ? choice[0] : fruits[right];
                choice[1] = choice[1] == fruits[last] ? choice[1] : fruits[right];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end
