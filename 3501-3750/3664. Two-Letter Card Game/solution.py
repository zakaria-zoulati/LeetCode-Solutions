class Solution:
    def score(self, cards: List[str], X: str) -> int:
        wilds = 0 
        f1 = [0]*10 
        f2 = [0]*10 
        for x , y in cards :
            if x == y == X : 
                wilds += 1
            elif x == X : 
                f1[ ord(y) - ord('a') ] += 1 
            elif y == X : 
                f2[ ord(x) - ord('a') ] += 1
            
        pairs = free = 0 
        for f in [ f1 , f2 ] : 
            s = sum( f )
            m = max( f )
            p = min( s - m  ,  s//2 )
            pairs += p 
            free += s - 2*p 
        used = min( wilds , free )
        wilds -= used 
        extra = min( pairs , wilds//2 )
        return pairs + used + extra 