/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {

  public boolean canJump(int[] nums) {
    //获取数组的长度
    int len = nums.length;
    //假设跳的最远的距离
    int farthest = 0;
    //在这里  n-1  为了排除  [0]  只有一个元素这种情况
    for (int i = 0; i < len - 1; i++) {
      //利用贪心不断选择最大的跳跃长度
      farthest = Math.max(farthest, i + nums[i]);
      //遇到 0   过不去了
      if (farthest <= i) {
        return false;
      }
    }
    return farthest >= len - 1;
  }
}
// @lc code=end
