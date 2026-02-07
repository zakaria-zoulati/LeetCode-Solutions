class Solution:
    def minimumDeletions(self, s: str) -> int:
        dp = 0 
        bs = 0
        for c in s : 
            if c == 'b' : 
                bs += 1 
            else :
                dp = min( dp + 1 , bs )
        return dp 