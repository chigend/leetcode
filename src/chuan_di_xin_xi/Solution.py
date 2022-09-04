class Solution(object):
    def numWays(self, n, relation, k):
        dp = [[i for i in range(n)] for _ in range(k + 1)]
        dp[0][0] = 1
        for i in range(k + 1):
            for edge in relation:
                dp[i][edge[1]] += dp[i - 1][edge[0]]

        return dp[k][n - 1]
