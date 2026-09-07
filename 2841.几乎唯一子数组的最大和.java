/*
 * @lc app=leetcode.cn id=2841 lang=java
 *
 * [2841] 几乎唯一子数组的最大和
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        long ans = 0;
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            sum += nums.get(i);
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }
        if (map.size() >= m) {
            ans = sum;
        }
        for (int i = k; i < nums.size(); i++) {
            // 处理右边入
            int rightNum = nums.get(i);
            sum += rightNum;
            int counts = 0;
            if (map.containsKey(rightNum)) {
                counts = map.get(rightNum);
                map.put(rightNum, counts + 1);
            } else {
                map.put(rightNum, 1);
            }
            // 处理左边出
            int leftNum = nums.get(i - k);
            sum -= leftNum;
            counts = map.get(leftNum);
            if (counts <= 1) {
                map.remove(leftNum);
            } else {
                map.put(leftNum, counts - 1);
            }
            if (map.size() >= m) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
// @lc code=end
