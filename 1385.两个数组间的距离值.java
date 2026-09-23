/*
 * @lc app=leetcode.cn id=1385 lang=java
 *
 * [1385] 两个数组间的距离值
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int ans = 0;
        int j = 0;
        for (int x : arr1) {
            while (j < arr2.length && arr2[j] < x - d) {
                j++;
            }
            if (j == arr2.length || arr2[j] > x + d) {
                ans++;
            }
        }
        return ans;
    }

}
// @lc code=end
