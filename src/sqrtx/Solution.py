class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0: return 0;

        l = 1
        r = x
        while l < r:
            mid = r + (l - r >> 1)
            if x / mid <= mid:
                r = mid
            else:
                l = mid + 1
        return r - 1 if x / r < r else r
