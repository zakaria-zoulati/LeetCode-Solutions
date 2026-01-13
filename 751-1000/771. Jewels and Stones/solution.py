class Solution(object):
    def numJewelsInStones(self, jewels, stones):
        rs = 0 
        for ch in stones :
            if ch in jewels : 
                rs += 1
        return rs 

        