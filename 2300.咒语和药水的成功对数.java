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
        int[] ans = new int[n];

        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int index = 0;
            if (spells[i] < success) {
                index = lowerBound(potions, success, spells[i]);
            }
            ans[i] = potions.length - index;
        }
        return ans;
    }

    private int lowerBound(int[] arr, long target, int spell) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if ((long) arr[mid] * spell < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end
