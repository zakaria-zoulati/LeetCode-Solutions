from typing import List

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        m = len(matrix[0])

        col1 = False
        row1 = False
        for i in range(m):
            if matrix[0][i] == 0:
                row1 = True
                break
        for i in range(n):
            if matrix[i][0] == 0:
                col1 = True
                break
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 0:
                    matrix[0][j] = 0
                    matrix[i][0] = 0

        for i in range(1, n):
            for j in range(1, m):
                if matrix[0][j] == 0 or matrix[i][0] == 0:
                    matrix[i][j] = 0

        if row1:
            for i in range(m):
                matrix[0][i] = 0
        if col1:
            for i in range(n):
                matrix[i][0] = 0