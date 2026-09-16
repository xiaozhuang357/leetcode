/*
 * @lc app=leetcode.cn id=3134 lang=java
 *
 * [3134] 找出唯一性数组的中位数
 */

// @lc code=start

import java.util.*;

class Solution {
    public int medianOfUniquenessArray(int[] nums) {

        int len = nums.length;
        // 唯一性数组长度
        long total = (long) (len + 1) * len / 2;
        // 中位数位置
        long need = (total + 1) / 2;

        int left = 1;
        int right = len;
        // 二分查找
        while (left < right) {

            int mid = left + (right - left) / 2;

            long count = countAsMost(nums, mid);
            if (count < need) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public long countAsMost(int[] nums, int k) {
        long ans = 0;

        int distinct = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            cnt.merge(nums[right], 1, Integer::sum);

            if (cnt.get(nums[right]) == 1) {
                distinct++;
            }
            while (distinct > k) {

                cnt.merge(nums[left], -1, Integer::sum);

                if (cnt.get(nums[left]) == 0) {
                    distinct--;
                }

                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
// @lc code=end
