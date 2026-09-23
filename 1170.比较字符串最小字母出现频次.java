/*
 * @lc app=leetcode.cn id=1170 lang=java
 *
 * [1170] 比较字符串最小字母出现频次
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] cnt1 = new int[queries.length];
        int[] cnt2 = new int[words.length];
        for (int i = 0; i < queries.length; i++) {
            cnt1[i] = f(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            cnt2[i] = f(words[i]);
        }
        Arrays.sort(cnt2);
        for (int i = 0; i < cnt1.length; i++) {
            int index = lowerBound(cnt2, cnt1[i] + 1);
            ans[i] = cnt2.length - index;

        }
        return ans;
    }

    public int f(String s) {
        int ans = 0;
        char[] S = s.toCharArray();
        int[] cnt = new int[26];
        for (char c : S) {
            cnt[c - 'a']++;
        }
        for (int i : cnt) {
            if (i != 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public int lowerBound(int[] nums, int target) {
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
}
// @lc code=end
