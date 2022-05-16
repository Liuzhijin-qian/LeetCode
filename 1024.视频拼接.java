/*
 * @lc app=leetcode.cn id=1024 lang=java
 *
 * [1024] 视频拼接
 */

// @lc code=start
class Solution {

  public int videoStitching(int[][] clips, int time) {
    if (time == 0) return 0;
    // 按起点升序排列，起点相同的降序排列
    Arrays.sort(
      clips,
      (a, b) -> {
        if (a[0] == b[0]) {
          return b[1] - a[1];
        }
        return a[0] - b[0];
      }
    );
    //已经对视频片段排完顺序
    //需要返回结果
    int res = 0;
    //当前指针指向
    int curEnd = 0, nextEnd = 0;
    int i = 0, n = clips.length;
    if (clips[0][0] != 0) return -1;
    while (i < n && clips[i][0] <= curEnd) {
      while (i < n && clips[i][0] <= curEnd) {
        nextEnd = Math.max(nextEnd, clips[i][1]);
        i++; //指向的视频片段
      }
      res++;
      curEnd = nextEnd;
      if (curEnd >= time) {
        return res;
      }
    }
    return -1;
  }
}
// @lc code=end
