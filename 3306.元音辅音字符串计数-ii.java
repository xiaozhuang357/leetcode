/*
 * @lc app=leetcode.cn id=3306 lang=java
 *
 * [3306] 元音辅音字符串计数 II
 */

// @lc code=start
import java.util.*;

class Solution {

    String yuan = "aeiou";

    public long countOfSubstrings(String word, int k) {
        long ans = 0;
        Map<Character, Integer> cnt1 = new HashMap<>();
        Map<Character, Integer> cnt2 = new HashMap<>();
        char[] S = word.toCharArray();
        int left1 = 0;
        int left2 = 0;
        int covered1 = 0;
        int covered2 = 0;

        for (int right = 0; right < S.length; right++) {

            covered1 = add(cnt1, S[right], covered1);

            while (covered1 == 5 && cnt1.getOrDefault('A', 0) >= k) {
                covered1 = de(cnt1, S[left1], covered1);
                left1++;
            }
            ans += left1;

            covered2 = add(cnt2, S[right], covered2);
            while (covered2 == 5 && cnt2.getOrDefault('A', 0) > k) {
                covered2 = de(cnt2, S[left2], covered2);
                left2++;
            }
            ans -= left2;
        }

        return ans;
    }

    public int add(Map<Character, Integer> cnt, char c, int covered) {
        if (yuan.indexOf(c) != -1) {
            if (cnt.getOrDefault(c, 0) == 0) {
                covered++;
            }
            cnt.merge(c, 1, Integer::sum);
        } else {
            cnt.merge('A', 1, Integer::sum);
        }
        return covered;
    }

    public int de(Map<Character, Integer> cnt, char c, int covered) {
        if (yuan.indexOf(c) != -1) {
            if (cnt.getOrDefault(c, 0) == 1) {
                covered--;
            }
            cnt.merge(c, -1, Integer::sum);
        } else {
            cnt.merge('A', -1, Integer::sum);
        }
        return covered;
    }
}
// @lc code=end
