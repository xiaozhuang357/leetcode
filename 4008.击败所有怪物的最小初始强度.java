/*
 * @lc app=leetcode.cn id=4008 lang=java
 *
 * [4008] 击败所有怪物的最小初始强度
 */

// @lc code=start
class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        long[] adds = new long[monsters.length + 1];
        for (int[] b : boosts) {
            adds[b[0]] += b[2];
            adds[b[1] + 1] -= b[2];
        }
        for (int i = 1; i < adds.length; i++) {
            adds[i] += adds[i - 1];
        }
        long left = 0;
        long right = 0;
        for (int i : monsters) {
            right += i;
        }
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (check(monsters, mid, adds)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static boolean check(int[] monsters, long initialStrength, long[] adds) {
        for (int i = 0; i < monsters.length; i++) {
            if (adds[i] + initialStrength >= monsters[i]) {
                initialStrength = Math.max(0, initialStrength - monsters[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
