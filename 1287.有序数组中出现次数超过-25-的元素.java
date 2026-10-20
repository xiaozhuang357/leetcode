/*
 * @lc app=leetcode.cn id=1287 lang=java
 *
 * [1287] 有序数组中出现次数超过25%的元素
 */

// @lc code=start
class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int m = n / 4;
        for (int i : new int[] { m, 2 * m + 1 }) {
            if (lowerBound(arr, arr[i] + 1) - lowerBound(arr, arr[i]) > m) {
                return arr[i];
            }
        }
        return arr[3 * m + 2];

    }

    static int lowerBound(int [] arr,int target){
        int left = 0;
        int right = arr.length;

        while (left<right) {
            int mid = left+(right -left)/2;

            if (arr[mid] < target) {
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end

1 2 3 3 3 4 5 6 7 8 5 2 1 0 5 7 8 9
