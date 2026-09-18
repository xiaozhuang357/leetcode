/*
 * @lc app=leetcode.cn id=2537 lang=java
 *
 * [2537] 统计好子数组的数目
 */

// @lc code=start
import java.util.*;

class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;

        int left = 0;
        int covered = 0;

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            int rightnum = nums[right];
            cnt.merge(rightnum, 1, Integer::sum);
            covered += cnt.get(rightnum) - 1;

            while (covered >= k) {
                int leftnum = nums[left];
                cnt.merge(leftnum, -1, Integer::sum);
                covered -= cnt.get(leftnum);

                if (cnt.get(leftnum) == 0) {
                    cnt.remove(leftnum);
                }
                left++;
            }

            ans += left;
        }
        return ans;
    }
}
// @lc code=end
