class Solution(object):
    def reversePrefix(self, word, ch):
        i = word.find(ch) 
        s = word[:i+1]
        t = ""
        if i+1 < len( word ) :
            t = word[i+1:]
        return s[::-1] + t 

        