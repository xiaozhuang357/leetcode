/*
 * @lc app=leetcode.cn id=2831 lang=java
 *
 * [2831] 找出最长等值子数组
 */

// @lc code=start
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            pos.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        for (List<Integer> vec : pos.values()) {
            for (int right = 0, left = 0; right < vec.size(); right++) {
                while (vec.get(right) - vec.get(left) - (right - left) > k) {
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;

    }
}
// @lc code=end
