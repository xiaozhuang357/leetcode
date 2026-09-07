/*
 * @lc app=leetcode.cn id=1658 lang=java
 *
 * [1658] 将 x 减到 0 的最小操作数
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int x) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < x) {
            return -1;
        }
        if (sum == x) {
            return nums.length;
        }
        int ans = 0;
        int left = 0;
        int right = 0;
        for (; right < nums.length; right++) {
            sum -= nums[right];
            while (sum < x) {
                sum += nums[left++];
            }
            if (sum == x) {
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans == 0 ? -1 : nums.length - ans;
    }
}
// @lc code=end
