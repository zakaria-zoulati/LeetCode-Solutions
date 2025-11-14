class Solution:
    def maxOperations(self, s: str) -> int:
        n = len(s)
        ans = 0
        prev = 0
        i = 0
        while i < n:
            if s[i] == "1":
                prev += 1
            else:
                ans += prev
                while i + 1 < n and s[i + 1] == "0":
                    i += 1
            i += 1
        return ans
