/*
 * @lc app=leetcode.cn id=64 lang=cpp
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution
{
public:
    int memo[202][202];
    int minPathSum(vector<vector<int>> &grid)
    {
        int m = grid.size();
        int n = grid[0].size(); //列数
        int memo[201][201];
        for (int i = 0; i < 202; i++)
        {
            for (int j = 0; j < 202; j++)
            {
                memo[i][j] = -1;
            }
        }
        return dp(grid, m - 1, n - 1);
    }
    int dp(vector<vector<int>> &grid, int i, int j)
    {
        //最终会回到左上角
        if (i == 0 && j == 0)
        {
            return grid[0][0];
        }
        //出界
        if (i < 0 || j < 0)
        {
            return 9999999;
        }
        if (memo[i][j] != -1)
            return memo[i][j];

        memo[i][j] = min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];
        return memo[i][j];
    }
};
// @lc code=end
