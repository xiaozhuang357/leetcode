/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (matrix[mid][m - 1] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int[] arr = matrix[left];
        if (arr[0] > target || arr[m - 1] < target) {
            return false;
        }
        left = 0;
        right = m - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (arr[left] == target) {
            return true;
        }
        return false;

    }
}
// @lc code=end
