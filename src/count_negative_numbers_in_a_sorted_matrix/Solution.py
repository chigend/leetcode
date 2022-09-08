from typing import List


class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        m = len(grid)
        if m == 0: return 0
        n = len(grid[0])
        j = n - 1
        res = 0
        for i in range(m):
            while j:
                if (grid[i][j] >= 0):
                    break
                else:
                    j -= 1
            res += j

        return res
