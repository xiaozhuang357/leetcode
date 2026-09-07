/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // // 首先，外层哈希，确定s中某一个字符串的字母数和word中相匹配
        // // 在细分这个字符串一个一个比较确认
        // int[] allCnt = new int[26];
        // // 统计words中每一个字符串的字母个数哈希,创建字符串哈希
        // int wordNum = words.length;
        // int wordLength = words[0].length();
        // Map<String, Integer> wordHashMap = new HashMap<>();
        // for (int i = 0; i < wordNum; i++) {
        // wordHashMap.merge(words[i], 1, Integer::sum);
        // for (char c : words[i].toCharArray()) {
        // allCnt[c - 'a']++;// words哈希
        // }
        // }
        // int[] cnts = new int[26];
        // List<Integer> ans = new ArrayList<>();
        // for (int right = 0; right < s.length(); right++) {
        // cnts[s.charAt(right) - 'a']++;// 右端点进入窗口
        // int left = right - wordNum * wordLength + 1;
        // if (left < 0) {
        // continue;
        // }
        // // 外层窗口匹配，进入内部筛选
        // Map<String, Integer> windowMap = new HashMap<>();
        // if (Arrays.equals(cnts, allCnt)) {
        // int ll = left;
        // for (int i = 0; i < wordNum; i++) {
        // String bar = s.substring(ll, ll + wordLength);
        // windowMap.merge(bar, 1, Integer::sum);
        // ll += wordLength;
        // }
        // if (wordHashMap.equals(windowMap)) {
        // ans.add(left);
        // }
        // }
        // cnts[s.charAt(left) - 'a']--;// 左端点出窗口
        // }
        // return ans;
        int wordNum = words.length;
        int wordLength = words[0].length();
        int sl = s.length();
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        // 创建word哈希
        for (String str : words) {
            wordMap.merge(str, 1, Integer::sum);
        }
        // 创建外层窗口
        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> windMap = new HashMap<>();
            for (int right = i; right + wordLength <= sl; right += wordLength) {
                windMap.merge(s.substring(right, right + wordLength), 1, Integer::sum);
                int left = right - wordLength * (wordNum-1);
                if (left < i) {
                    continue;
                }
                if (wordMap.equals(windMap)) {
                    ans.add(left);
                }
                //左端点出窗口
                String leftString = s.substring(left, left + wordLength);
                windMap.merge(leftString, -1, Integer::sum);
                if (windMap.get(leftString) == 0) {
                    windMap.remove(leftString);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

6
0 1 2 3 4 5