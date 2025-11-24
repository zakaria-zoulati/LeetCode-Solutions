from typing import Optional , List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        ans = []

        def helper(root: Optional[TreeNode]) -> None:
            if root:
                ans.append(root.val)
                helper(root.left)
                helper(root.right)

        helper(root)
        return ans
