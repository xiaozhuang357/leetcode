/*
 * @lc app=leetcode.cn id=2962 lang=java
 *
 * [2962] 统计最大元素出现至少 K 次的子数组
 */

// @lc code=start
class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;

        int max = Integer.MIN_VALUE;

        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }

        int cnt = 0;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                cnt++;
            }

            while (cnt == k) {
                if (nums[left] == max) {
                    cnt--;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
// @lc code=end
