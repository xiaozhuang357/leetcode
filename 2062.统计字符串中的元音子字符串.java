/*
 * @lc app=leetcode.cn id=2062 lang=java
 *
 * [2062] 统计字符串中的元音子字符串
 */

// @lc code=start
import java.util.*;

class Solution {
    public int countVowelSubstrings(String word) {
        int ans = 0;
        char[] S = word.toCharArray();

        Map<Character, Integer> cnt = new HashMap<>();
        cnt.put('a', 0);
        cnt.put('e', 0);
        cnt.put('i', 0);
        cnt.put('o', 0);
        cnt.put('u', 0);

        int left = 0;
        int index = 0;
        int cover = 0;
        for (int right = 0; right < S.length; right++) {
            if (isVowel(S[right])) {
                if (cnt.get(S[right]) == 0) {
                    cover++;
                }
                cnt.merge(S[right], 1, Integer::sum);
            } else {
                cnt.put('a', 0);
                cnt.put('e', 0);
                cnt.put('i', 0);
                cnt.put('o', 0);
                cnt.put('u', 0);
                index = right + 1;
                left = right + 1;
                cover = 0;
            }
            while (cover >= 5) {

                if (cnt.get(S[left]) == 1) {
                    cover--;
                }
                cnt.merge(S[left], -1, Integer::sum);
                left++;
            }

            ans += left - index;
        }

        return ans;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
// @lc code=end
