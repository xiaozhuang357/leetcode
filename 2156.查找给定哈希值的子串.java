/*
 * @lc app=leetcode.cn id=2156 lang=java
 *
 * [2156] 查找给定哈希值的子串
 */

// @lc code=start
class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long hash = 0;
        int ansLeft = s.length() - 1;
        for (int left = s.length() - 1; left >= 0; left--) {
            // 左端点进窗口
            hash = (hash * power + (s.charAt(left) & 31)) % modulo;
            int right = left + k - 1;
            if (right > s.length() - 1) {
                continue;
            }
            if (hash == hashValue) {
                ansLeft = left;
            }
            // 右端点出窗口
            hash = (hash - (s.charAt(right) & 31) * qpow(power, k - 1, modulo) % modulo + modulo) % modulo;

        }
        return s.substring(ansLeft, ansLeft + k);
    }

    public long qpow(long power, int k, int modulo) {
        long ans = 1 % modulo;
        while (k != 0) {
            if ((k & 1) == 1) {
                ans = ans * power % modulo;
            }
            power = power * power % modulo;
            k >>= 1;
        }
        return ans;
    }
}
// @lc code=end
