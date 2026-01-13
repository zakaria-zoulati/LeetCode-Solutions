class Solution(object):
    def beautifulSubstrings(self, s, k):
        vows = [] 
        cons = []
        v = 0 
        c = 0 
        all = "aeuio"
        for ch in s  :
            if ch in all :
                v += 1
            else :
                c += 1
            vows.append(v)
            cons.append(c)
        rs = 0 
        for i in range(1,len(s)) :
            if vows[i] == cons[i] and ( vows[i] * cons[i] ) % k == 0:
                rs += 1
        for i in range( 0 ,  len(s) ) :
            for j in range( i+2 , len(s) ) : 
                a = vows[j] - vows[i] 
                b = cons[j] - cons[i]
                if a == b and ( a * b ) % k == 0:
                    rs += 1
        return rs 