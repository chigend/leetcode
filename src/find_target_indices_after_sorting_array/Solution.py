class Solution(object):
    def targetIndices(self, nums, target):
        lt_target = 0
        eq_target = 0
        for num in nums:
            if num < target:
                lt_target += 1

            if num == target:
                eq_target += 1

        res = []
        for i in range(lt_target, lt_target + eq_target):
            res.append(i)
        return res
