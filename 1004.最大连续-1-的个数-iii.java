/*
 * @lc app=leetcode.cn id=1004 lang=java
 *
 * [1004] 最大连续1的个数 III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int cnt = 0;
        int ans = 0;
        int left = 0;
        int right = 0;
        for (; right < nums.length; right++) {
            if (nums[right] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (nums[left++] == 0) {
                    cnt--;
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end
