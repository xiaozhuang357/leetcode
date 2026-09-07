/*
 * @lc app=leetcode.cn id=3679 lang=java
 *
 * [3679] 使库存平衡的最少丢弃次数
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int ans = 0;
        boolean[] window = new boolean[w];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < w; i++) {
            int count = map.getOrDefault(arrivals[i], 0);
            if (count == m) {
                ans++;
            } else {
                window[i] = true;
                map.put(arrivals[i], count + 1);
            }
        }
        for (int i = w; i < arrivals.length; i++) {
            if (window[(i - w) % w]) {
                map.put(arrivals[i - w], map.get(arrivals[i - w]) - 1);
                window[(i - w) % w] = false;
            }
            if (map.getOrDefault(arrivals[i], 0) == m) {
                ans++;
            } else {
                map.put(arrivals[i], map.getOrDefault(arrivals[i], 0) + 1);
                window[i % w] = true;
            }
        }
        return ans;
    }
}
// @lc code=end
