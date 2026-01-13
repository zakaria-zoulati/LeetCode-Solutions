class Solution(object):
    def sumOfMultiples(self, n):
        rs = 0 
        for i in range(3,n+1) : 
            if i%3==0 or i%5==0 or i%7==0 :
                rs += i 
        return rs 