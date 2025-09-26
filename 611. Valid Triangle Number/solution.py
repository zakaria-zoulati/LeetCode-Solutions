class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        n : int = len( nums )
        nums.sort()
        rs = 0 
        for i in range( n-1 , 1 , -1 ) : 
            l = 0 
            r = i-1 
            while l<r : 
                if nums[l] + nums[r] > nums[i] : 
                    rs += r - l 
                    r -= 1 
                else : 
                    l += 1 
        return rs 