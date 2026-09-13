/*
 * @lc app=leetcode.cn id=3795 lang=java
 *
 * [3795] 不同元素和至少为 K 的最短子数组长度
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minLength(int[] nums, int k) {
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            int x = nums[right];

            if (freq.getOrDefault(x, 0) == 0) {
                sum += x;
            }
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            while (left <= right && sum >= k) {
                ans = Math.min(ans, right - left + 1);
                int y = nums[left];
                freq.put(y, freq.get(y) - 1);

                if (freq.get(y) == 0) {
                    sum -= y;
                    freq.remove(y);
                }
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
// @lc code=end
