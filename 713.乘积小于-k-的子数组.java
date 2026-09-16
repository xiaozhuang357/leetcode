/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] 乘积小于 K 的子数组
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        long product = 1;
        if (k <= 1) {
            return 0;
        }

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            ans += right - left + 1;
        }
        return ans;
    }
}
// @lc code=end
