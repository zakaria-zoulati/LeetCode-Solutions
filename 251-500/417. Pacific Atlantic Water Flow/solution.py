class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        dirs = [ [1,0] , [-1,0] , [0,1] , [0,-1] ]
        n = len( heights )
        m = len( heights[0] )
        checked = [ [0]*m for i in range(n) ]
        seen = [ [False]*m for i in range(n) ]
        q = []
        # The Pacific Ocean
        for i in range(n) : 
            q.append( [i,0] )
            seen[i][0] = True  
            checked[i][0] = 1 
        for i in range(1,m) : 
            q.append( [0,i] )
            seen[0][i] = True 
            checked[0][i] = 1 
        while q : 
            l = len(q) 
            while l > 0 : 
                e = q.pop()
                for dir in dirs : 
                    x = e[0] + dir[0]
                    y = e[1] + dir[1]
                    if x>=0 and y>=0 and x<n and y<m and not seen[x][y] and heights[ e[0] ][ e[1] ] <= heights[x][y] : 
                        seen[x][y] = True 
                        checked[x][y] = 1 
                        q.append( [x,y] )
                l -= 1
                
        # The Atlantic Ocean 
        seen = [ [False]*m for i in range(n) ]
        for i in range(n) :
                q.append( [ i , m-1 ] )
                seen[i][m-1] = True 
                checked[i][m-1] += 2 
        for i in range(m-1) : 
                q.append( [n-1,i] )
                seen[n-1][i] = True 
                checked[n-1][i] += 2 
        while q : 
            l = len(q) 
            while l > 0 : 
                e = q.pop() 
                for dir in dirs : 
                    x = e[0] + dir[0]
                    y = e[1] + dir[1]
                    if x>=0 and y>=0 and x<n and y<m and not seen[x][y] and heights[ e[0] ][ e[1] ] <= heights[x][y] : 
                        seen[x][y] = True 
                        checked[x][y] += 2
                        q.append( [x , y] )
                l -= 1 

        ans = []
        for i in range(n) :
            for j in range(m) : 
                if checked[i][j] == 3 : 
                    ans.append( [i,j] )

        return ans 