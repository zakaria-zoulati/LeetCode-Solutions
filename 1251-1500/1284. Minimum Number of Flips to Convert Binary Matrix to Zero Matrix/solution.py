class Solution : 
    def minFlips(self, mat: List[List[int]]) -> int:
        n = len( mat )
        m = len( mat[0] )
        k = n*m 
        mask = 1 << k 
        ans = k + 1
        for i in range( mask ) : 
            curr = 0 
            diff = copy.deepcopy(mat)
            for j in range( k ) : 
                if (( i >> j ) & 1) == 1 :
                    curr += 1 
                    row = j // m 
                    col = j % m
                    diff[row][col] ^= 1 
                    for dx , dy in [ (0,1) , (0,-1) , (1,0) , (-1,0) ] : 
                        x = row + dx 
                        y = col + dy 
                        if x>=0 and y>=0 and x<n and y<m : 
                            diff[x][y] ^= 1 
            for j in range( n ) : 
                for t in range( m ) : 
                    if diff[j][t] == 1 : 
                        curr = k + 1 
                        break 
            ans = min( ans , curr ) 
        return -1 if ans == k+1 else ans