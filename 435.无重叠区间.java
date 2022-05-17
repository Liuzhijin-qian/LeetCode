/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
  int[] memo;

  // 主函数
  public int jump(int[] nums) {
    int n = nums.length;
    // 备忘录都初始化为 n，相当于 INT_MAX
    // 因为从 0 跳到 n - 1 最多 n - 1 步
    memo = new int[n];
    Arrays.fill(memo, n);

    return dp(nums, 0);
  }

  // 定义：从索引 p 跳到最后一格，至少需要 dp(nums, p) 步
  int dp(int[] nums, int p) {
    int n = nums.length;
    // base case
    if (p >= n - 1) {
      return 0;
    }
    // 子问题已经计算过
    if (memo[p] != n) {
      return memo[p];
    }
    int steps = nums[p];
    // 你可以选择跳 1 步，2 步...
    for (int i = 1; i <= steps; i++) {
      // 穷举每一个选择
      // 计算每一个子问题的结果
      int subProblem = dp(nums, p + i);
      // 取其中最小的作为最终结果
      memo[p] = Math.min(memo[p], subProblem + 1);
    }
    return memo[p];
  }
}
// @lc code=end
