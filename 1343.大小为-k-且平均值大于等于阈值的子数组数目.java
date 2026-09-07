/*
 * @lc app=leetcode.cn id=1343 lang=java
 *
 * [1343] 大小为 K 且平均值大于等于阈值的子数组数目
 */

// @lc code=start
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int minSum = k * threshold;
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= minSum) {
            ans++;
        }
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            if (sum >= minSum) {
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end
