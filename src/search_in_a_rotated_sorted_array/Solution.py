from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        pivot = self.find_pivot(nums)
        index = self.binary_search(nums, 0, pivot, target)
        return index if index != -1 else self.binary_search(nums,pivot + 1, len(nums) - 1,target)

    def find_pivot(self, nums):
        l = 0
        r = len(nums) - 1
        t = nums[r]
        while l < r:
            mid = l + r + 1>> 1
            if nums[mid] > t:
                l = mid
            else:
                r = mid - 1
        return r

    def binary_search(self, nums, l, r, target):
        while l < r:
            mid = l + r >> 1
            if nums[mid] >= target:
                r = mid
            else:
                l = mid + 1
        return r if nums[r] == target else -1


if __name__ == '__main__':
    s = Solution()
    print(s.search([3, 1], 0))