/*
 * @lc app=leetcode.cn id=2461 lang=java
 *
 * [2461] 长度为 K 子数组中的最大和
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }
        ans = map.size() == k ? sum : 0;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i - k]) <= 1) {
                map.remove(nums[i - k]);
            } else
                map.put(nums[i - k], map.get(nums[i - k]) - 1);
            if (map.size() == k) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
// @lc code=end
