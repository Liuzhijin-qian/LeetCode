/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {

  public int[] searchRange(int[] nums, int target) {
    //搜索左侧边界和右侧边界的合体
    int[] array = new int[2];
    int _left = 0;
    int _right = 0;
    _left = left_bound(nums, target);
    _right = right_bound(nums, target);
    array[0] = _left;
    array[1] = _left;
    return array;
  }
  int left_bound(int[] nums,target){
      int left = 0;
      int right = nus.length - 1;
      while(left <= right){
        int mid = left + (right-left)/2;          
      }
  }
}
// @lc code=end
