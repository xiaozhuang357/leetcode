/*
 * @lc app=leetcode.cn id=2302 lang=java
 *
 * [2302] 统计得分小于 K 的子数组数目
 */

// @lc code=start
class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;

        int left = 0;
        long windSum = 0;
        for (int right = 0; right < nums.length; right++) {
            long windLen = right - left + 1;
            windSum += nums[right];

            while (windLen * windSum >= k) {
                windSum -= nums[left];
                left++;
                windLen--;
            }

            ans += windLen;
        }
        return ans;
    }
}
// @lc code=end

