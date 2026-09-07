/*
 * @lc app=leetcode.cn id=3634 lang=java
 *
 * [3634] 使数组平衡的最少移除数目
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;
        int left = 0;
        int right = 0;
        for (; right < n; right++) {
            while ((long) k * nums[left] < nums[right]) {
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return n - max;
    }
}
// @lc code=end
