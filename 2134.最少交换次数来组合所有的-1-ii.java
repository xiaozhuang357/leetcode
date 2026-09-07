/*
 * @lc app=leetcode.cn id=2134 lang=java
 *
 * [2134] 最少交换次数来组合所有的 1 II
 */

// @lc code=start
class Solution {
    public int minSwaps(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            cnt += num;
        }
        if (cnt == nums.length) {
            return 0;
        }
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < cnt; i++) {
            sum += nums[i];
        }
        ans = sum;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            sum += nums[(i + cnt) % nums.length];
            ans = Math.max(ans, sum);
        }
        return cnt - ans;
    }
}
// @lc code=end
