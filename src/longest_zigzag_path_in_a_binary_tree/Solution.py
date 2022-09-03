from src.model.TreeNode import TreeNode


class Solution:

    len = 0

    def longestZigZag(self, root: TreeNode) -> int:
        self.dfs(root, 0,0)
        return self.len

    def dfs(self, root, left, right) -> int:
        self.len = max(self.len, max(left, right))
        if root.left:
            self.dfs(root.left, right + 1, 0)
        if root.right:
            self.dfs(root.right, 0, left+1)