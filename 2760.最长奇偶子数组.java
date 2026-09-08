/*
 * @lc app=leetcode.cn id=2760 lang=java
 *
 * [2760] 最长奇偶子数组
 */

// @lc code=start
class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int i = 0;
        int ans = 0;
        while (i < n) {
            if (nums[i] > threshold || nums[i] % 2 != 0) {
                i++;
                continue;
            }
            int start = i;
            i++;
            while (i < n && nums[i] <= threshold && nums[i] % 2 != nums[i - 1] % 2) {
                i++;
            }
            ans = Math.max(ans, i - start);
        }
        return ans;
    }
}
// @lc code=end
