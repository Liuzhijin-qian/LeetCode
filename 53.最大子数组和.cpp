/*
 * @lc app=leetcode.cn id=53 lang=cpp
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution
{
public:
    int maxSubArray(vector<int> &nums)
    {
        if (nums.size() == 0)
        {
            return 0;
        }
        vector<int> dp(nums.size());
        dp[0] = nums[0];
        for (int i = 1; i < nums.size(); i++)
        {
            dp[i] = max(nums[i], nums[i] + dp[i - 1]);
        }
        int res = -99999;
        for (int i = 0; i < nums.size(); ++i)
        {
            res = max(res, dp[i]);
        }
        return res;
    }
};
// @lc code=end
