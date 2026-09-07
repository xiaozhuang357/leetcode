/*
 * @lc app=leetcode.cn id=2958 lang=java
 *
 * [2958] 最多 K 个重复元素的最长子数组
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (; right < n; right++) {
            cnt.merge(nums[right], 1, Integer::sum);
            while (cnt.get(nums[right]) > k) {
                cnt.merge(nums[left++], -1, Integer::sum);
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end
