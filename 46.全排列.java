/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
  List<List<Integer>> res = new LinkedList<>(); //创建保存结果的链表

  public List<List<Integer>> permute(int[] nums) {
    //保存走过的路径
    LinkedList<Integer> track = new LinkedList<>();
    //若数字已经被选择，标记为true，反之为false
    boolean[] used = new boolean[nums.length];
    backtrace(nums, track, used);
    return res;
  }

  void backtrace(int[] nums, LinkedList<Integer> track, boolean[] used) {
    //结束条件
    if (track.size() == nums.length) {
      res.add(new LinkedList(track));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      //做选择之前先判断，当前数组里面的值是否已被使用过
      if (used[i] == true) {
        continue; //调到下一个数字
      }
      //做选择
      track.add(nums[i]);
      used[i] = true;
      //选择下一个枝条
      backtrace(nums, track, used);
      //撤销选择
      track.removeLast();
      used[i] = false;
    }
  }
}
// @lc code=end
