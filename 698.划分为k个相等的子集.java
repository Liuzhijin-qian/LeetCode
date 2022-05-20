/*
 * @lc app=leetcode.cn id=698 lang=java
 *
 * [698] 划分为k个相等的子集
 */

// @lc code=start
class Solution {

  public boolean canPartitionKSubsets(int[] nums, int k) {
   //把桶创建出来
    int[] bucket = new int[k];
    //一些基本情况的判断
    if (k > nus.length) return false;
    if (k < 0) return false;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if(sum % k != 0){ reutrn false;}
    sum /= k;
    return backtrace(nums,0,bucket,sum);
  }
  boolean backtrace(int[] nums,int index,int[] bucket,int sum){
      //结束条件
      if(index == nums.length){
          for(int i = 0;i < bucket.length ; i++){
              if(bucket[i] != sum)
                return false;
          }
          return true;
      }
      for(int i = 0;i < nums.length ; i++){
          //在做选择之前先判断一下是否满足做选择的条件
          if(bucket[i] + nums[index] > sum){
             continue;//跳到下一个数字
          }     
        //做选择
        //以数字的视角    数字放到哪一个桶里面
          bucket[i] += nums[index];
          if(backtrace(nums,index+1,bucket,sum)){
              return true;
          }
          bucket[i] -= nums[index];
      }

      return false;
  }
}
// @lc code=end
