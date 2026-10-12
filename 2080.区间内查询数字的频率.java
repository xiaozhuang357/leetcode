/*
 * @lc app=leetcode.cn id=2080 lang=java
 *
 * [2080] 区间内查询数字的频率
 */

// @lc code=start

import java.util.*;

class RangeFreqQuery {

    private Map<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        if (map.get(value) == null) {
            return 0;
        }
        int leftBound = lowerBound(map.get(value), left);
        int rightBound = lowerBound(map.get(value), right + 1) - 1;
        return rightBound - leftBound + 1;
    }

    private int lowerBound(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
// @lc code=end
