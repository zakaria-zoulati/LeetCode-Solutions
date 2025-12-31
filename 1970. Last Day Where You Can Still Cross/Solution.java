class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int len = row*col ; 
        DSU dsu = new DSU( row * col + 2 ) ; 
        int[][] grid = new int[row][col] ; 
        int[][] dirs = { {0,1} , {0,-1} , {1,0} , {-1,0} } ; 


        for( int i=len-1 ; i>=0 ; --i ){
            int r = cells[i][0] - 1; 
            int c = cells[i][1] - 1 ; 
            grid[r][c] = 1 ; 

            int id = r*col + c + 1 ; 

            for( int[] d : dirs ){
                int nr = r + d[0] ; 
                int nc = c + d[1] ; 
                if( nr >= 0 && nr < row && nc>=0 && nc < col && grid[nr][nc] == 1 ){
                    dsu.union( id , nr*col + nc + 1 ) ; 
                }
            }

            if( r == 0 ){
                dsu.union( 0 , id ) ; 
            }
            if( r == row -1 ){
                dsu.union( row*col + 1 , id ) ; 
            }
            if( dsu.find( 0 ) == dsu.find( row*col + 1 ) ){
                return i ; 
            }
        }
        return -1 ; 
    }
}


class DSU {
    int[] root ; 
    DSU( int n ){
        root = new int[n] ; 
        for( int i=0 ; i<n ; ++i ){
            root[i] = i ; 
        }
    } 
    int find( int x ){
        if( root[x] != x ){
            root[x] = find( root[x] ) ; 
        }
        return root[x] ; 
    }
    void union( int x , int y ){
        int rx = find( x ) ; 
        int ry = find( y ) ; 
        if( rx == ry ) return ; 
        root[rx] = ry ; 
    }
}