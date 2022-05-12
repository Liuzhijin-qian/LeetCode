/*
 * @lc app=leetcode.cn id=222 lang=cpp
 *
 * [222] 完全二叉树的节点个数
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution
{
public:
    int countNodes(TreeNode *root)
    {
        TreeNode *l = root;
        TreeNode *r = root;
        int leftNode = 0;
        int rightNode = 0;
        while (l != nullptr)
        {
            l = l->left;
            leftNode++;
        }
        while (r != nullptr)
        {
            r = r->right;
            rightNode++;
        }
        if (leftNode == rightNode)
        {
            return pow(2, leftNode) - 1;
        }
        return 1 + countNodes(root->left) + countNodes(root->right);
    }
};
// @lc code=end
