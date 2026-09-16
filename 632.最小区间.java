/*
 * @lc app=leetcode.cn id=632 lang=java
 *
 * [632] 最小区间
 */

// @lc code=start
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        //整数列表的数量
        int k = nums.size();
        int[] ans = new int[2];
        //初始化
        ans[0] = 0;
        ans[1] = Integer.MAX_VALUE;
        //整数的数目
        int sumLen = 0;
        for (List<Integer> list : nums) {
            sumLen += list.size();
        }
        //创建序列表 （整数值，列表序号）
        int[][] pairs = new int[sumLen][2];
        int pi = 0;
        for (int i = 0; i < k; i++) {
            for (int x : nums.get(i)) {
                pairs[pi][0] = x;
                pairs[pi++][1] = i;
            }
        }
        //排序
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        
        //已经覆盖的数量
        int coverd = 0;
        // 记录来自每一组的数量
        int[] cnt = new int[k];
        int left = 0;
        for (int right = 0; right < pairs.length; right++) {
            int rightId = pairs[right][1];
            // 右断点进窗口
            if (cnt[rightId] == 0) {
                coverd++;
            }
            cnt[rightId]++;

            while (coverd == k) {

                //判断窗口是否需要更换
                int curLeft = pairs[left][0];
                int curRight = pairs[right][0];
                int newWindLen = curRight -curLeft;
                int oldWindLen = ans[1] -ans[0];
                if (newWindLen < oldWindLen || (newWindLen == oldWindLen && curLeft < ans[0])) {
                    ans[0] = curLeft;
                    ans[1] = curRight;
                }

                int leftId = pairs[left][1];

                cnt[leftId]--;
                if (cnt[leftId] == 0) {
                    coverd--;
                }
                left++;

            }
        }
        return ans;
    }
}
// @lc code=end
