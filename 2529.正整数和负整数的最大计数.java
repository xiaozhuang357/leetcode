/*
 * @lc app=leetcode.cn id=2529 lang=java
 *
 * [2529] 正整数和负整数的最大计数
 */

// @lc code=start
class Solution {
    public int maximumCount(int[] nums) {
        int start = lowerBound(nums, 0);

        int end = lowerBound(nums, 1);

        return Math.max(start, nums.length - end);

    }

    public int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

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
