class Solution(object):
    def minimumPairRemoval(self, nums):
        def isGood( nums ) : 
            for i in range(1,len(nums)) : 
                if nums[i] < nums[i-1] : 
                    return False 
            return True 

        ops = 0 
        while not isGood(nums) :
            best_i = 0 
            curr = nums[0] + nums[1]
            for i in range(1,len(nums)-1) : 
                if nums[i] + nums[i+1] < curr : 
                    best_i = i  
                    curr = nums[i] + nums[i+1]
            nums[best_i] = curr
            del nums[best_i+1] 
            ops += 1 
        return ops 