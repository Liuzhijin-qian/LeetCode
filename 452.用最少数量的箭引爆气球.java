/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {

  public int findMinArrowShots(int[][] points) {
    if (points.length == 0) return 0;
    Arrays.sort(
      points,
      (o1, o2) -> {
        if (o1[1] > o2[1]) return 1;
        if (o1[1] < o2[1]) return -1;
        return 0;
      }
    ); //完成数组的排序
      //排序且防止数据溢出

    //重叠区间至少一个
    int count = 1;
    //排好序  第一个数组最后一个数字
    int x_end = points[0][1];
    for (int[] inver : points) {
      int start = inver[0];
      if (start > x_end) {
        count++;
        x_end = inver[1];
      }
    }
    return count;
  }
}
// @lc code=end
