/*
 * @lc app=leetcode.cn id=3694 lang=java
 *
 * [3694] 删除子字符串后不同的终点
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private static final int[][] DIRS = new int[128][];
    static {
        DIRS['U'] = new int[] { 0, 1 };
        DIRS['D'] = new int[] { 0, -1 };
        DIRS['L'] = new int[] { -1, 0 };
        DIRS['R'] = new int[] { 1, 0 };

    }

    public int distinctPoints(String s, int k) {
        int n = s.length();
        int x = 0, y = 0;
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            x += DIRS[s.charAt(i)][0];
            y += DIRS[s.charAt(i)][1];

            int left = i - k + 1;
            if (left < 0) {
                continue;
            }
            set.add((long) (x + n) << 20 | (y + n));

            x -= DIRS[s.charAt(left)][0];
            y -= DIRS[s.charAt(left)][1];
        }
        return set.size();
    }

}
// @lc code=end
