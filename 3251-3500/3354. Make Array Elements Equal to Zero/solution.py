from typing import List

class Solution:
    def valid( self , pref : List[int] , s:int , n:int , i:int ) -> int : 
        if s == 0 :
            return 2 
        l = pref[i] 
        r = s - pref[i] 
        if l == r :
            return 2 
        elif abs( l - r ) <= 1 :
            return 1 
        return 0 

    def countValidSelections(self, nums: List[int]) -> int:
        n = len( nums )
        pref = [0]*n 
        pref[0] = nums[0]
        s = nums[0]
        for i in range( 1 , n ) :
            pref[i] = pref[i-1] + nums[i]
            s += nums[i]
        ans = 0 
        for i in range( n ) : 
            if nums[i] == 0 : 
                ans += self.valid( pref , s , n , i )
        return ans 