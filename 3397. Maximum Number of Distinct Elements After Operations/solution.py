class Solution:
    def maxDistinctElements(self, nums: List[int], k: int) -> int:
        n = len( nums )
        nums.sort() 
        last_assigned = float( '-inf' )
        ans = 0 
        for i in range( n ) : 
            candidate = max( nums[i] - k , last_assigned + 1 ) 
            if candidate <= nums[i] + k : 
                last_assigned = candidate 
                ans += 1
        return ans 