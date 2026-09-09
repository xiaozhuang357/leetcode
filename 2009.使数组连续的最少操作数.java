/*
 * @lc app=leetcode.cn id=2009 lang=java
 *
 * [2009] 使数组连续的最少操作数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        // 先排序
        Arrays.sort(nums);
        int m = 0;
        // 去重，相同的元素一定是挨在一起的
        for (int x : nums) {
            if (m == 0 || nums[m - 1] != x) {
                nums[m++] = x;
            }
        }
        int maxKeep = 0;
        int left = 0;
        for (int right = 0; right < m; right++) {
            while (nums[right] - nums[left] > n - 1) {
                left++;
            }
            maxKeep = Math.max(maxKeep, right - left + 1);
        }
        return n - maxKeep;
    }
}
// @lc code=end
