/*
 * @lc app=leetcode.cn id=72 lang=cpp
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution
{
public:
    int Min(int a, int b, int c)
    {
        return min(a, min(b, c));
    }
    int minDistance(string word1, string word2)
    {
        int m = word1.length();
        int n = word2.length();
        return dp(word1, m - 1, word2, n - 1);
    }
    int dp(string word1, int i, string word2, int j)
    {
        // base case
        if (i == -1)
            return j + 1;
        if (j == -1)
            return i + 1;
        if (word1.compare(i, 1, word2, j, 1) == 1)
        {
            dp(word1, i - 1, word2, j - 1);
        }
        return Min(
            dp(word1, i, word2, j - 1) + 1,    //插入
            dp(word1, i - 1, word2, j) + 1,    //删除
            dp(word1, i - 1, word2, j - 1) + 1 //替换
        );
    }
};
// @lc code=end
