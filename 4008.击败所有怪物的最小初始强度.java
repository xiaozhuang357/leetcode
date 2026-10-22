/*
 * @lc app=leetcode.cn id=4008 lang=java
 *
 * [4008] 击败所有怪物的最小初始强度
 */

// @lc code=start
class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long[] adds = new long[n + 1];
        for (int[] b : boosts) {
            adds[b[0]] += b[2];
            adds[b[1] + 1] -= b[2];
        }
        for (int i = 1; i < adds.length; i++) {
            adds[i] += adds[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            if (adds[i] < monsters[i]) {
                long ans = -adds[i];
                for (int j = i; j >= 0; j--) {
                    ans += monsters[j];
                }
                return ans;
            }
        }
        return 0;
    }
}
// @lc code=end
