fmax = lambda x,y : x if x > y else y
fmin = lambda x,y : x if x < y else y 
INF = 10 ** 20

class Solution:
    def minCost(self, nums: List[int]) -> int:
        n = len( nums ) 
        @cache
        def go( index , past ) -> int :
            if index >= n:
                return past
            if index + 1 >= n : 
                return  fmax( nums[index] , past )
            
            best = INF 
            a , b , c = past , nums[index] , nums[index+1] 
            best = fmin( best , go(index+2 , a ) + fmax(b,c) )
            best = fmin( best , go(index+2 , b ) + fmax(a,c) )
            best = fmin( best , go(index+2 , c ) + fmax(a,b) )
            return best

        r = go( 1 , nums[0] )
        go.cache_clear()
        return r 