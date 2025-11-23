class Solution:
    def maximumBinaryString(self, s: str) -> str:
        if "0" not in s:
            return s

        k = s.count("1", s.find("0"))
        n = len(s)

        ans = "1" * (n - k - 1) + "0" + "1" * k
        return ans
