/*
 * @lc app=leetcode.cn id=1695 lang=java
 *
 * [1695] 删除子数组的最大得分
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int ans = 0;
        int left = 0;
        int right = 0;
        Set<Integer> set = new HashSet<>();
        for (; right < nums.length; right++) {
            sum += nums[right];
            if (set.contains(nums[right])) {
                while (nums[left] != nums[right]) {
                    sum -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }
                sum -= nums[left++];
            } else {
                set.add(nums[right]);
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
// @lc code=end
