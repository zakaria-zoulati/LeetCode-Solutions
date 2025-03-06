class Solution {
    public int nearestExit(char[][] grid, int[] entrance) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        Queue< int[] > q = new LinkedList<>() ; 
        int a = entrance[0] ;
        int b = entrance[1] ;
        grid[a][b] = '+' ; 
        if( a+1<n && grid[a+1][b] == '.' ){  
            q.add( new int[]{ a+1 , b , 1 } ) ;  
        }   
        if( a-1>=0 && grid[a-1][b] == '.' ){  
            q.add( new int[]{ a-1 , b , 1 } ) ;  
        }
        if( b+1<m && grid[a][b+1] == '.' ){
            q.add( new int[]{ a , b+1 , 1 } ) ;  
        }
        if( b-1>=0 && grid[a][b-1] == '.' ){
            q.add( new int[]{ a , b-1 , 1 } ) ; 
        }

        while( !q.isEmpty() ){
            int[] curr = q.poll() ; 
            int x = curr[0] ; 
            int y = curr[1] ; 
            if( grid[x][y] == '+'  ){
                continue ;
            }
            if( x == 0 || x == n-1 ) return curr[2] ; 
            if( y == 0 || y == m-1 ) return curr[2] ;
            grid[x][y] = '+' ; 
            int t = x+1 ; 
            if( t<n && grid[t][y] == '.' ){
                q.add( new int[]{ t , y , curr[2] + 1 } ) ; 
            }
            t = x-1; 
            if( t>=0 && grid[t][y] == '.' ){
                q.add( new int[]{ t , y , curr[2] + 1 } ) ; 
            }
            t = y+1 ; 
            if( t<m && grid[x][t] == '.' ){
                q.add( new int[]{ x , t , curr[2] + 1 } ) ; 
            }
            t = y-1 ;
            if( t>=0 && grid[x][t] == '.' ){
                q.add( new int[]{ x , t , curr[2] + 1 } ) ; 
            }
        }
        return -1 ;
    }
}