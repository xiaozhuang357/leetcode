/*
 * @lc app=leetcode.cn id=981 lang=java
 *
 * [981] 基于时间的键值存储
 */

// @lc code=start

import java.util.*;

class TimeMap {

    int curTimeStamp = 0;

    class Pair {
        String k, v;
        int t;

        public Pair(String _k, String _v, int _t) {
            k = _k;
            v = _v;
            t = _t;
        }
    }

    Map<String, List<Pair>> history = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        history.computeIfAbsent(key, k -> new ArrayList<Pair>()).add(new Pair(key, value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!history.containsKey(key)) {
            return "";
        }
        List<Pair> h = history.get(key);
        int left = 0;
        int right = h.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (h.get(mid).t <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == 0 ? "" : h.get(left - 1).v;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end
