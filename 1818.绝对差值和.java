/*
 * @lc app=leetcode.cn id=1818 lang=java
 *
 * [1818] 绝对差值和
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int) 1e9 + 7;

        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        int n = nums1.length;
        long sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) {
                continue;
            }
            int x = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + x) % mod;
            int index = LowerBound(sorted, nums2[i]);
            int nd = Math.abs(sorted[index] - nums2[i]);
            if (index > 0) {
                nd = Math.min(nd, Math.abs(sorted[index - 1] - nums2[i]));
            }
            if (nd < x) {
                max = Math.max(max, x - nd);
            }
        }
        return (int) ((sum - max + mod) % mod);
    }

    private int LowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end
