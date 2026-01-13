class Solution(object):
    def numDecodings(self, s):
        n = len(s) 
        dp = [0]*(n+1) 
        dp[n] = 1 
        dp[n-1] = 1 if s[n-1] != '0' else 0 
        for i in range( n-2 , -1 , -1 ) : 
            if s[i] == '0' : 
                dp[i] = 0 
            elif s[i] > '2' : 
                dp[i] = dp[i+1] 
            elif s[i] == '1' : 
                dp[i] = dp[i+1] + dp[i+2]
            elif s[i+1] <= '6' : 
                dp[i] = dp[i+1] + dp[i+2] 
            else : 
                dp[i] = dp[i+1] 
        return dp[0]        
        