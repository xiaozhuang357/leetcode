/*
 * @lc app=leetcode.cn id=2563 lang=java
 *
 * [2563] 统计公平数对的数目
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int lowerBound = lowerBound(nums, lower - nums[i], i);
            int upperBound = lowerBound(nums, upper - nums[i] + 1, i);
            ans += upperBound - lowerBound;
        }

        return ans;
    }

    private int lowerBound(int[] nums, int target, int right) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
// @lc code=end
