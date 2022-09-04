class Solution(object):
    def findKthPositive(self, arr, k):
        l = 0
        r = len(arr) - 1
        while l < r:
            mid = (l + r + 1) >> 1
            diff = arr[mid] - mid - 1
            if diff < k:
                l = mid
            else:
                r = mid - 1

        d = arr[r] - r - 1
        return r + k + 1 if d < k else k
