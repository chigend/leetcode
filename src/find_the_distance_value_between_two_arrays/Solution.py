from typing import List


class Solution:
    def findTheDistanceValue(self, arr1: List[int], arr2: List[int], d: int) -> int:
        arr2.sort()
        res = 0
        for num in arr1:
            res += self.binary_search(arr2, num - d, num + d)
        return res

    def binary_search(self, nums, low, high):
        l = 0
        r = len(nums) - 1
        while l <= r:
            mid = l + r >> 1
            if nums[mid] >= low and nums[mid] <= high:
                return 0
            elif nums[mid] > high:
                r = mid - 1
            else:
                l = mid + 1
        return 1
