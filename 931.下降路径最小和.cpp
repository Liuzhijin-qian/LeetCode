/*
 * @lc app=leetcode.cn id=931 lang=cpp
 *
 * [931] 下降路径最小和
 */

// @lc code=start
class Solution
{
public:
    int memo[1000][1000] = {0};
    int min3(int a, int b, int c)
    {
        return min(a, min(b, c));
    }
    int minFallingPathSum(vector<vector<int>> &matrix)
    {

        for (int i = 0; i < 1000; i++)
        {
            for (int j = 0; j < 1000; j++)
            {
                memo[i][j] = 88888;
            }
        }
        int n = matrix.size();
        int res = 999999;
        for (int j = 0; j < n; j++)
        {
            res = min(res, dp(matrix, n - 1, j));
        }
        return res;
    }

    int dp(vector<vector<int>> &matrix, int i, int j)
    {
        //数组非法下标检查
        if (i < 0 || j < 0 || j >= matrix[0].size())
        {
            return 999999;
        }
        if (i == 0)
        {
            return matrix[0][j];
        }
        if (memo[i][j] != 88888)
        {
            return memo[i][j];
        }
        memo[i][j] = matrix[i][j] + min3(
                                        dp(matrix, i - 1, j),
                                        dp(matrix, i - 1, j - 1),
                                        dp(matrix, i - 1, j + 1));
        return memo[i][j];
    }
};
// @lc code=end
