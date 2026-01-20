class Solution(object):
    def minBitwiseArray(self, nums):
        def helper( n ) :
            p = -1 
            copy = n 
            while copy & 1 :
                p += 1 
                copy >>= 1

            return n - ( 1 << p )

        n = len(nums)
        ans = [-1]*n 
        for i in range(len(nums)) : 
            if nums[i] & 1 :
                ans[i] = helper( nums[i] )

        return ans        