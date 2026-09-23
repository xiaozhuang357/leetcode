/*
 * @lc app=leetcode.cn id=1712 lang=java
 *
 * [1712] 将数组分成三个子数组的方案数
 */

// @lc code=start
class Solution {
    private static long mod = 1_000_000_007;

    public int waysToSplit(int[] nums) {
        long ans = 0;
        int n = nums.length;
        long[] pre = new long[n + 1];

        // 前缀和
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        long total = pre[n];

        // i是mid开始的位置
        // left [0,i)
        // mid [i,j)
        // right [j,n-1)
        for (int i = 1; i < n - 1; i++) {

            // 界定min和max的边界情况
            long min = 2 * pre[i];

            long max = (total + pre[i]) / 2;

            int leftBound = lowerBound(pre, i + 1, n, min);

            //找到第一个>max的位置
            int rightBound = upperBound(pre, i + 1, n, max);

            if (leftBound < rightBound) {
                ans += rightBound - leftBound;
                ans %= mod;
            }

        }
        return (int) ans;

    }

    // 找到[left,right)中第一个>=target的数
    public int lowerBound(long[] arr, int left, int right, long target) {
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 找到[left,right)中第一个 >target的数
    public int upperBound(long[] arr, int left, int right, long target) {
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end
