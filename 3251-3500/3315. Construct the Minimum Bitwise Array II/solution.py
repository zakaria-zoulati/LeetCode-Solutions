class Solution(object):
    def minBitwiseArray(self, nums):
        def helper( n ) :
            m = n+1
            curr = m&-m 
            m -= curr 
            curr >>= 1
            return m + curr - 1

        n = len(nums)
        ans = [-1]*n 
        for i in range(len(nums)) : 
            if nums[i] & 1 :
                ans[i] = helper( nums[i] )

        return ans        