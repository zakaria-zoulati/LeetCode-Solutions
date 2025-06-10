class Solution(object):
    def trap(self, height):
        n = len( height ) 
        if n <= 2 :
            return 0 
        l = 0 
        r = n-1 
        rs = 0  
        leftMax = height[0] 
        rightMax = height[n-1]
        while l < r : 
            if leftMax < rightMax : 
                l += 1 
                leftMax = max( leftMax , height[l] )
                rs += leftMax - height[l] 
            else : 
                r -= 1 
                rightMax = max( rightMax , height[r] ) 
                rs += rightMax - height[r]
        return rs 
        