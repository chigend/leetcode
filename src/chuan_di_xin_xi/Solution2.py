from collections import deque


class Solution(object):
    def numWays(self, n, relation, k):
        hash = {}
        for edge in relation:
            if edge[0] not in hash:
                hash[edge[0]] = []
            hash[edge[0]].append(edge[1])

        q = deque()
        q.append(0)
        count = 0
        while k and q:
            k -= 1
            size = len(q)
            for i in range(size):
                t = q.popleft()
                if t in hash:
                    for v in hash[t]:
                        if k == 0 and v == n - 1:
                            count += 1
                        q.append(v)

        return count


if __name__ == '__main__':
    s = Solution()
    d = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]];
    s.numWays(5,d,3)
