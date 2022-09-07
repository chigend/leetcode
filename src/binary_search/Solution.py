from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums) - 1
        while l < r:
            mid = l + r >> 1
            if nums[mid] >= target:
                r = mid
            else:
                l = mid + 1
        return r if nums[r] == target else -1