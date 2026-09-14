/*
 * @lc app=leetcode.cn id=2875 lang=java
 *
 * [2875] 无限数组的最短子数组
 */

// @lc code=start
class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        int nums_sum = 0;
        int len = nums.length;
        for (int num : nums) {
            nums_sum += num;
        }

        int n1 = target / nums_sum;
        int n2 = target % nums_sum;
        if (n2 == 0) {
            return n1 * len;
        }
        int[] N = new int[len * 2];
        for (int i = 0; i < N.length; i++) {
            N[i] = nums[i % len];
        }
        int left = 0;
        int sum = 0;
        for (int right = 0; right < N.length; right++) {
            sum += N[right];
            while (sum >= n2) {
                if (sum == n2) {
                    ans = Math.min(ans, right - left + 1);
                }
                sum -= N[left];
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans + n1 * len;
    }
}
// @lc code=end
