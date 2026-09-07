/*
 * @lc app=leetcode.cn id=1652 lang=java
 *
 * [1652] 拆炸弹
 */

// @lc code=start
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }
        int sum = 0;
        for (int i = 0; i < Math.abs(k); i++) {
            sum += code[i];
        }
        int start = k > 0 ? n - 1 : -k;
        ans[start % n] = sum;
        start++;
        for (int i = 0; i < n - 1; i++, start++) {
            sum += code[(i + Math.abs(k)) % n];
            sum -= code[i];
            ans[start % n] = sum;
        }
        return ans;
    }
}
// @lc code=end
