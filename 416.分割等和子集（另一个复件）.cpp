/*
 * @lc app=leetcode.cn id=416 lang=cpp
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution
{
public:
    bool canPartition(vector<int> &nums)
    {
        // base case
        int total = 0;
        for (int i : nums)
        {
            total += i;
        }
        if (total % 2 != 0)
            return false;
        int n = nums.size();
        total /= 2;
        bool dp[201][400000] = {false};

        for (int i = 0;  i <= n; i++)
        {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= total; j++)
            {
                if (j - nums[i - 1] < 0)
                    dp[i][j] = dp[i - 1][j];
                else
                {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][total];
    }
};
// @lc code=end
