from typing import List

class Solution:
    def countUnguarded(
        self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]
    ) -> int:
        n, m = m, n
        MIN = -float("inf")  # The wall
        MAX = float("inf")  # The Guard
        grid = [[0] * m for j in range(n)]
        for g in guards:
            grid[g[0]][g[1]] = MAX
        for w in walls:
            grid[w[0]][w[1]] = MIN

        for i in range(n):
            for j in range(m):
                if grid[i][j] == MAX:
                    for k in range(i + 1, n):
                        if grid[k][j] == MIN or grid[k][j] == MAX:
                            break
                        grid[k][j] -= 1
                    for k in range(i - 1, -1, -1):
                        if grid[k][j] == MIN or grid[k][j] == MAX:
                            break
                        grid[k][j] -= 1
                    for k in range(j + 1, m):
                        if grid[i][k] == MIN or grid[i][k] == MAX:
                            break
                        grid[i][k] -= 1
                    for k in range(j - 1, -1, -1):
                        if grid[i][k] == MIN or grid[i][k] == MAX:
                            break
                        grid[i][k] -= 1
        ans = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 0:
                    ans += 1
        return ans
