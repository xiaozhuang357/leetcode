/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pcnt = new int[26];
        int[] scnt = new int[26];
        // 统计p中每个字母的个数
        for (char c : p.toCharArray()) {
            pcnt[c - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        for (int right = 0; right < s.length(); right++) {
            scnt[s.charAt(right) - 'a']++;// 右端点进入窗口
            int left = right - p.length() + 1;
            if (right < p.length() - 1) {
                continue;
            }
            // 判断
            if (Arrays.equals(pcnt, scnt)) {
                res.add(left);
            }
            // 左端点退出窗口
            scnt[s.charAt(left) - 'a']--;
        }
        return res;
    }
}
// @lc code=end
