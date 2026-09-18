/*
 * @lc app=leetcode.cn id=2799 lang=java
 *
 * [2799] 统计完全子数组的数目
 */

// @lc code=start
import java.util.*;

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int ans = 0;

        int covered = 0;
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i : nums) {
            cnt.merge(i, 1, Integer::sum);
        }

        int kind = cnt.size();
        int left = 0;
        cnt.clear();

        for (int right = 0; right < nums.length; right++) {
            cnt.merge(nums[right], 1, Integer::sum);
            if (cnt.get(nums[right]) == 1) {
                covered++;
            }
            while (covered == kind) {
                cnt.merge(nums[left], -1, Integer::sum);
                if (cnt.get(nums[left]) == 0) {
                    covered--;
                    cnt.remove(nums[left]);
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
// @lc code=end
