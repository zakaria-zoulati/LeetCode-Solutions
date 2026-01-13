class Solution(object):
    def halvesAreAlike(self, s):
        """
        :type s: str
        :rtype: bool
        """
        n = len(s) 
        a = 0  
        b = 0 
        vowels = "aeuioAEUIO"
        for i in range(0 , n/2) : 
            if s[i] in vowels : 
                a += 1
        for i in range(n/2 , n ) : 
            if s[i] in vowels : 
                b += 1
        return a == b 
        