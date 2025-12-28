from typing import List

class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        ans = 0
        col = m
        for i in range(n):
            while col > 0 and grid[i][col - 1] < 0:
                col -= 1
            ans += m - col

        return ans
