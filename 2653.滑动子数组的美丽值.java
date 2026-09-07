/*
 * @lc app=leetcode.cn id=2653 lang=java
 *
 * [2653] 滑动子数组的美丽值
 */

// @lc code=start

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] ans = new int[nums.length - k + 1];
        int[] cnt = new int[101];
        for (int i = 0; i < k; i++) {
            cnt[nums[i] + 50]++;
        }
        ans[0] = findXthSmallest(cnt, x);
        for (int i = k; i < nums.length; i++) {
            cnt[nums[i] + 50]++;
            cnt[nums[i - k] + 50]--;
            ans[i - k + 1] = findXthSmallest(cnt, x);
        }
        return ans;
    }

    public int findXthSmallest(int[] nums, int x) {
        for (int i = 0; i < 50; i++) {
            x -= nums[i];
            if (x <= 0) {
                return i - 50;
            }
        }
        return 0;
    }

}
// @lc code=end
