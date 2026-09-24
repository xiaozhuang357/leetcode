/*
 * @lc app=leetcode.cn id=2300 lang=java
 *
 * [2300] 咒语和药水的成功对数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = spells[i];
            pairs[i][1] = i;
        }
        Arrays.sort(potions);
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));

        int j = m - 1;
        for (int[] pair : pairs) {
            int spell = pair[0];
            int index = pair[1];
            while (j >= 0 && (long) potions[j] * spell >= success) {
                j--;
            }
            ans[index] = m - j - 1;
        }

        return ans;
    }
}
// @lc code=end
