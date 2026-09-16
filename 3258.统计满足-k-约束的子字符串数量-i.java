/*
 * @lc app=leetcode.cn id=3258 lang=java
 *
 * [3258] 统计满足 K 约束的子字符串数量 I
 */

// @lc code=start
class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int ans = 0;
        char[] S = s.toCharArray();
        
        int left = 0;
        int[] cnt = new int[2];
        for (int right = 0; right < S.length; right++) {
            cnt[S[right] - '0']++;

            while (cnt[0] > k && cnt[1] > k) {
                cnt[S[left] - '0']--;
                left++;
            }
            
            ans += right - left + 1;
        }
        return ans;
    }
}
// @lc code=end

