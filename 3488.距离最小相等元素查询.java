/*
 * @lc app=leetcode.cn id=3488 lang=java
 *
 * [3488] 距离最小相等元素查询
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // value -> 出现位置
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // dist[i] 表示下标 i 到最近相同元素的环形距离
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        for (List<Integer> positions : map.values()) {
            int m = positions.size();

            // 只出现一次
            if (m == 1) {
                continue;
            }

            for (int i = 0; i < m; i++) {
                int cur = positions.get(i);

                // 环形的前一个相同元素
                int prev = positions.get((i - 1 + m) % m);

                // 环形的后一个相同元素
                int next = positions.get((i + 1) % m);

                int d1 = circularDistance(cur, prev, n);
                int d2 = circularDistance(cur, next, n);

                dist[cur] = Math.min(d1, d2);
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int query : queries) {
            answer.add(dist[query]);
        }

        return answer;
    }

    private int circularDistance(int a, int b, int n) {
        int d = Math.abs(a - b);
        return Math.min(d, n - d);
    }
}
// @lc code=end
