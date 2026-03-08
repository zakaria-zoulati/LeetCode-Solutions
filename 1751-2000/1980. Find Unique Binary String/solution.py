from typing import List

class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        def helper( num , n ) : 
            s = "" 
            for i in range( n ) : 
                if num % 2 == 0 : 
                    s = "0" + s  
                else : 
                    s = "1" + s
                num >>= 1 
            return s
        n = len(nums)
        for i in range(1<<n) : 
            flag = True 
            for num in nums : 
                if int( num , 2 ) == i : 
                    flag = False 
                    break 
            if flag : 
                return helper( i , n )