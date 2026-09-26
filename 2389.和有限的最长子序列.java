/*
 * @lc app=leetcode.cn id=2389 lang=java
 *
 * [2389] 和有限的最长子序列
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];

        Arrays.sort(nums);

        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }

        for (int i = 0; i < queries.length; i++) {
            // int index = lowerBound(pre, queries[i]);
            // if (index < pre.length && pre[index] == queries[i]) {
            //     ans[i] = index + 1;
            // } else {
            //     ans[i] = index;
            // }
            ans[i] = upperBound(pre, queries[i]);
        }

        return ans;
    }

    private int lowerBound(int nums[], int target) {
        int left = 0;
        int right = nums.length;

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
    
    private int upperBound(int nums[], int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end
