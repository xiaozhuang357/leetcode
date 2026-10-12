/*
 * @lc app=leetcode.cn id=1146 lang=java
 *
 * [1146] 快照数组
 */

// @lc code=start

import java.util.*;

class SnapshotArray {

    int curSnapId = 0;

    Map<Integer, List<int[]>> history = new HashMap<>();

    public SnapshotArray(int length) {

    }

    public void set(int index, int val) {
        history.computeIfAbsent(index, k -> new ArrayList<>()).add(new int[] { curSnapId, val });
    }

    public int snap() {
        return curSnapId++;
    }

    public int get(int index, int snap_id) {
        if (!history.containsKey(index)) {
            return 0;
        }
        List<int[]> h = history.get(index);
        int j = search(h, snap_id);
        return j < 0 ? 0 : h.get(j)[1];
    }

    private int search(List<int[]> h, int x) {
        int left = -1;
        int right = h.size();
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (h.get(mid)[0] <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
// @lc code=end
