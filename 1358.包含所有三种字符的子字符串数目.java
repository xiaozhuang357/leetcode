/*
 * @lc app=leetcode.cn id=1358 lang=java
 *
 * [1358] 包含所有三种字符的子字符串数目
 */

// @lc code=start
class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;

        char[] S = s.toCharArray();

        int left = 0;

        int[] cnt = new int[3];

        for (int right = 0; right < S.length; right++) {
            // 右断点入窗口
            cnt[S[right] - 'a']++;

            while (cnt[0] >= 1 && cnt[1] >= 1 && cnt[2] >= 1) {

                cnt[S[left] - 'a']--;
                left++;
            }
            ans += left;

        }

        return ans;
    }
}
// @lc code=end
