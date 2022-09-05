from typing import List


class Solution:
    def specialArray(self, nums: List[int]) -> int:
        N = 1010
        count = [0] * N
        for num in nums:
            count[num] += 1
        res = 0
        for i in range(1001):
            x = 1000 - i
            res += count[x]
            if res == x:
                return x
        return -1
