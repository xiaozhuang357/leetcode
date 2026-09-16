/*
 * @lc app=leetcode.cn id=2762 lang=java
 *
 * [2762] 不间断子数组
 */

// @lc code=start

import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int left = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int right = 0; right < nums.length; right++) {

            map.merge(nums[right], 1, Integer::sum);

            while (map.lastKey() - map.firstKey() > 2) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            
            ans += right - left + 1;
        }
        return ans;
    }
}
// @lc code=end
