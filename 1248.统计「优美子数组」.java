/*
 * @lc app=leetcode.cn id=1248 lang=java
 *
 * [1248] 统计「优美子数组」
 */

// @lc code=start
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int[] cnt = new int[2];
        int left1 = 0;
        int left2 = 0;

        for (int right = 0; right < nums.length; right++) {
            cnt[0] += nums[right] % 2;
            while (cnt[0] >= k) {
                cnt[0] -= nums[left1++] % 2;
            }
            ans += left1;

            cnt[1] += nums[right] % 2;
            while (cnt[1] > k) {
                cnt[1] -= nums[left2++] % 2;
            }
            ans -= left2;
        }
        return ans;
    }
}
// @lc code=end
