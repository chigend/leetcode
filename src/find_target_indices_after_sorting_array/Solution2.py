class Solution(object):
    def targetIndices(self, nums, target):
        nums.sort()

        l = 0
        r = len(nums) - 1
        while l < r:
            mid = (l + r) >> 1
            if nums[mid] >= target:
                r = mid
            else: l = mid + 1
        if nums[r] != target: return []

        low = r
        l = 0
        r = len(nums) - 1
        while l < r:
            mid = (l + r + 1) >> 1
            if nums[mid] <= target:
                l = mid
            else: r = mid - 1

        res = []
        for i in range(low, r + 1):
            res.append(i)
        return res