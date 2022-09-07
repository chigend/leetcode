from src.model import TreeNode


class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        return self.dfs(original, cloned, target)

    def dfs(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        if original is None:
            return None

        if original == target:
            return cloned

        left = self.dfs(original.left, cloned.left, target)
        return self.dfs(original.right, cloned.right, target) if left is None else left