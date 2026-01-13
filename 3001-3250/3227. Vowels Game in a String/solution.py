class Solution(object):
    def doesAliceWin(self, s):
        string = "aeuio"
        for i in s :
            if i in string :
                return True
        return False 
      
        