from typing import List

class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        n = len( nums ) 
        def helper( nums : List[int] , sign : int ) -> int :
            prev = nums[0] 
            curr = 1 
            for i in range( 1 , n ) : 
                if sign == 0 : 
                    if nums[i] > prev : 
                        curr += 1 
                        prev = nums[i]
                        sign ^= 1 
                    else :
                        prev = min( prev , nums[i] ) 
                else :
                    if nums[i] < prev : 
                        curr += 1 
                        prev = nums[i]
                        sign ^= 1 
                    else :
                        prev = max( prev , nums[i] )
            return curr 
        ans = 0 
        ans = max( ans , helper( nums , 0 ) )
        ans = max( ans , helper( nums , 1 ) )
        return ans