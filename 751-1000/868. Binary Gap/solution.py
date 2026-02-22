class Solution:
    def binaryGap(self, n: int) -> int:
        ans = 0 
        prev = -1 
        curr = 0 
        while n : 
            if n % 2 == 1 : 
                if prev != -1 : 
                    ans = max( ans , curr - prev )
                prev = curr 
            n >>= 1 
            curr += 1 
        return ans 