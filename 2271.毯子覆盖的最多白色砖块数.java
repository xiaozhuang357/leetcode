/*
 * @lc app=leetcode.cn id=2271 lang=java
 *
 * [2271] 毯子覆盖的最多白色砖块数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);
        int ans = 0;
        int left = 0;
        int cover = 0;
        for (int i = 0; i < tiles.length; i++) {
            int tl = tiles[i][0];
            int tr = tiles[i][1];
            cover += tr - tl + 1;
            int carperLeft = tr - carpetLen + 1;
            while (tiles[left][1] < carperLeft) {
                cover -= tiles[left][1] - tiles[left][0] + 1;
                left++;
            }
            int uncover = Math.max(carperLeft - tiles[left][0], 0);
            ans = Math.max(ans, cover - uncover);
        }
        return ans;
    }
}
// @lc code=end
