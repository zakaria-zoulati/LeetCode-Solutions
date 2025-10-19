class Solution:
    def helper(self, dp: List[List[int]], n: int, ind: int, mask: int):
        if ind > n:
            return 1
        if dp[ind][mask] != -1:
            return dp[ind][mask]
        count = 0
        for i in range(1, n + 1):
            if (i % ind == 0 or ind % i == 0) and (mask & (1 << (i - 1)) == 0):
                count += self.helper(dp, n, ind + 1, mask | (1 << (i - 1)))
        dp[ind][mask] = count
        return dp[ind][mask]

    def countArrangement(self, n: int) -> int:
        dp: List[List[int]] = [[-1] * (1 << n) for i in range((n + 1))]
        return self.helper(dp, n, 1, 0)
