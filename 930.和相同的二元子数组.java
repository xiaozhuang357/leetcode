/*
 * @lc app=leetcode.cn id=930 lang=java
 *
 * [930] 和相同的二元子数组
 */

// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        int sum1 = 0;
        int sum2 = 0;
        int left1 = 0;
        int left2 = 0;

        for (int right = 0; right < nums.length; right++) {
            sum1 += nums[right];
            while (left1 <= right && sum1 >= goal) {
                sum1 -= nums[left1++];
            }
            ans += left1;

            sum2 += nums[right];
            while (sum2 > goal) {
                sum2 -= nums[left2++];
            }
            ans -= left2;
        }

        return ans;
    }
}
// @lc code=end
