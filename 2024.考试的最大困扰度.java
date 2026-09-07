/*
 * @lc app=leetcode.cn id=2024 lang=java
 *
 * [2024] 考试的最大困扰度
 */

// @lc code=start
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int f = 0;
        int t = 0;
        int ans = 0;
        int left = 0;
        int right = 0;
        for (; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'F') {
                f++;
            } else
                t++;
            while (Math.min(f, t) > k) {
                if (answerKey.charAt(left++) == 'F') {
                    f--;
                } else
                    t--;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end
