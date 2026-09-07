/*
 * @lc app=leetcode.cn id=1838 lang=java
 *
 * [1838] 最高频元素的频数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int left = 0;
        int ans = 0;
        for (int right = 1; right < nums.length; right++) {
            sum += (nums[right] - nums[right - 1]) * (right - left);
            while (sum > k) {
                sum -= nums[right] - nums[left];
                left++;
            }
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }
}
// @lc code=end
