/*
 * @lc app=leetcode.cn id=2779 lang=java
 *
 * [2779] 数组的最大美丽值
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int ans = 0;
        for (; right < nums.length; right++) {
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end
