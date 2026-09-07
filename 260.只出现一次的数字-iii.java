/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        int rightOne = eor & (-eor);
        int eor1 = 0;
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                eor1 ^= num;
            }
        }
        res[0] = eor1;
        res[1] = eor1 ^ eor;
        return res;
    }
}
// @lc code=end
