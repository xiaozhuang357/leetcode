/*
 * @lc app=leetcode.cn id=2401 lang=java
 *
 * [2401] 最长优雅子数组
 */

// @lc code=start
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans = 0;
        int left =0;
        int lable =0;
        for(int right = 0;right<nums.length;right++){
            while ((lable & nums[right]) != 0) {
                lable ^= nums[left];
                left++;
            }
            lable |= nums[right];
            ans = Math.max(ans, right - left + 1);

        }
        return ans;
    }
}
// @lc code=end

 




