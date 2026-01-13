class Solution(object):
    def mostWordsFound(self, sentences):
        rs = 0 
        for i in range( len(sentences) ) :
            rs = max( rs , len(  sentences[i].split(" ") ) )
        return rs 