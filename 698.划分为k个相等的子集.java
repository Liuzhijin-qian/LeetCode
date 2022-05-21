/*
 * @lc app=leetcode.cn id=698 lang=java
 *
 * [698] 划分为k个相等的子集
 */

// @lc code=start
class Solution {

  /********************************************************************** */
  // public boolean canPartitionKSubsets(int[] nums, int k) {
  //   //把桶创建出来
  //   int[] bucket = new int[k];
  //   //一些基本情况的判断
  //   if (k > nums.length) return false;
  //   //if (k < 0) return false;
  //   int sum = 0;
  //   for (int num : nums) {
  //     sum += num;
  //   }
  //   if (sum % k != 0) return false;
  //   sum /= k;
  //   return backtrace(nums, 0, bucket, sum);
  // }

  // boolean backtrace(int[] nums, int index, int[] bucket, int sum) {
  //   //结束条件
  //   if (index == nums.length) {
  //     for (int i = 0; i < bucket.length; i++) {
  //       if (bucket[i] != sum) return false;
  //     }
  //     return true;
  //   }
  //   for (int i = 0; i < bucket.length; i++) {
  //     //在做选择之前先判断一下是否满足做选择的条件
  //     if (bucket[i] + nums[index] > sum) {
  //       continue; //跳到下一个数字
  //     }
  //     //做选择
  //     //以数字的视角    数字放到哪一个桶里面
  //     bucket[i] += nums[index];
  //     if (backtrace(nums, index + 1, bucket, sum)) {
  //       return true;
  //     }
  //     bucket[i] -= nums[index];
  //   }

  //   return false;
  // }
  /********************************************************************** */
  //以上解法耗时较多，已经无法通过所有测试样例

  /********************************************************************** */
  //Sloution 2；
  //站在桶的视角
  // 1  遍历每一个数字，看当前数字放到桶里是否可以放满
  // 2  第k个桶放满之后，下一个桶开始遍历相关数字
  public boolean canPartitionKSubsets(int[] nums, int k) {
    //一些基本情况的讨论
    if (k > nums.length) return false;
    // if (k < nums.length) return false;
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    if (sum % k != 0) return false;
    int target = sum / k;
    boolean[] used = new boolean[nums.length];
    // return backtrace(nums, k, 0, used, 0, target);
    return backtrace(k, 0, nums, 0, used, target);
  }

  boolean backtrace(
    int k,
    int bucket,
    int[] nums,
    int index,
    boolean[] used,
    int target
  ) {
    //结束条件
    if (k == 0) return true;
    if (bucket == target) {
      return backtrace(k - 1, 0, nums, 0, used, target);
    }
    for (int i = index; i < nums.length; i++) {
      //首先判断当前数字是否使用过
      if (used[i]) {
        continue;
      }
      if (bucket + nums[i] > target) {
        continue;
      }
      used[i] = true;
      bucket += nums[i];
      if (backtrace(k, bucket, nums, i + 1, used, target)) {
        return true;
      }
      used[i] = false;
      bucket -= nums[i];
    }
    return false;
  }
}
// @lc code=end
