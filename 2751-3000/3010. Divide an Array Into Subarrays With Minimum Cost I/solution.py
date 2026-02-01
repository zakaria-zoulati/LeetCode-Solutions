class Solution:
    def minimumCost(self, nums: List[int]) -> int:
        a = nums[1] 
        b = nums[2] 
        for i in range(3,len(nums)) : 
            if nums[i] < a : 
                b = min( b , a )
                a = nums[i]
            elif nums[i] < b : 
                b = nums[i]
        ans = nums[0] + a + b 
        return ans  