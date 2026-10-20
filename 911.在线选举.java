/*
 * @lc app=leetcode.cn id=911 lang=java
 *
 * [911] 在线选举
 */

// @lc code=start
class TopVotedCandidate {

    int[] times;
    int[] winners;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        int n = persons.length;

        winners = new int[n];
        int[] cnt = new int[n];

        int curWin = -1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int p = persons[i];
            cnt[p]++;

            if (cnt[p] >= max) {
                max = cnt[p];
                curWin = p;
            }
            winners[i] = curWin;
        }
    }

    public int q(int t) {
        int left = 0;
        int right = times.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (times[mid] <= t) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return winners[left - 1];

    }

}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
// @lc code=end
