/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 *
 * https://leetcode.cn/problems/count-primes/description/
 *
 * algorithms
 * Medium (36.97%)
 * Likes:    1236
 * Dislikes: 0
 * Total Accepted:    315.4K
 * Total Submissions: 853.1K
 * Testcase Example:  '10'
 *
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 0
 * 输出：0
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：n = 1
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= n <= 5 * 10^6
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        int[] primes = new int[n];
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                primes[count++] = i;
            }
            for (int j = 0; j < count && (long) i * primes[j] < n; j++) {
                isPrime[i * primes[j]] = true;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
        return count;
    }
}
// @lc code=end
