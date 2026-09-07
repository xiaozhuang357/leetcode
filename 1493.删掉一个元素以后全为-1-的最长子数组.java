/*
 * @lc app=leetcode.cn id=1493 lang=java
 *
 * [1493] 删掉一个元素以后全为 1 的最长子数组
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        List<Integer> arr = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                arr.add(cnt);
                cnt = 0;
            }
        }
        arr.add(cnt);
        if (arr.size() == 1) {
            return nums.length - 1;
        }
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);

            int left = i - 2 + 1;
            if (left < 0) {
                continue;
            }

            ans = Math.max(ans, sum);

            sum -= arr.get(left);
        }
        return ans;
    }
}
// @lc code=end
