/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
  //声明备忘录
  // int[] memo;

  // public int jump(int[] nums) {
  //   int n = nums.length;
  //   memo = new int[n];
  //   Arrays.fill(memo, n);
  //   // 定义：从索引 p 跳到最后一格，至少需要 dp(nums, p) 步
  //   return dp(nums, 0);
  // }

  // int dp(int[] nums, int p) {
  //   //base case
  //   int n = nums.length;
  //   if (p >= n - 1) {
  //     return 0;
  //   }
  //   //如果备忘录不为空
  //   if (memo[p] != n) {
  //     return memo[p];
  //   }
  //   //拿到每一个位置可以前进的步数
  //   int steps = nums[p];
  //   for (int i = 1; i <= steps; i++) {
  //     int SubProblem = dp(nums, p + i);
  //     memo[p] = Math.min(memo[p], SubProblem + 1);
  //   }
  //   return memo[p];
  int[] memo;

  public int jump(int[] nums) {
    int n = nums.length;
    memo = new int[n];
    Arrays.fill(memo, n);
    // 定义：从索引 p 跳到最后一格，至少需要 dp(nums, p) 步
    return dp(nums, 0);
  }

  int dp(int[] nums, int p) {
    //base case
    int n = nums.length;
    if (p >= n - 1) {
      return 0;
    }
    //如果备忘录不为空
    if (memo[p] != n) {
      return memo[p];
    }
    //拿到每一个位置可以前进的步数
    int steps = nums[p];
    for (int i = 1; i <= steps; i++) {
      int SubProblem = dp(nums, p + i);
      memo[p] = Math.min(memo[p], SubProblem + 1);
    }
    return memo[p];
  }
}
// @lc code=end
