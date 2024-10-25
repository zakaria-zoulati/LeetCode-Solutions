class Solution {
    int[][] directions={{-1,0} , {1,0} , {0,-1} , {0,1}};
    int n ; 
    int m ; 
    public int numIslands(char[][] grid) {
        n=grid.length ; 
        m=grid[0].length ; 
        int rs = 0 ;  
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if( grid[i][j]=='1'){
                    dfs(grid,i,j); 
                    ++rs ;
                }
            }
        }
        return rs; 
    }
    public void dfs(char[][] grid,int i,int j){
        grid[i][j]='0'; 
        for(int[] d:directions){
            int x=i+d[0] ; 
            int y=j+d[1] ;
            if(x>=0 && y>=0 && x<n && y<m && grid[x][y]=='1'){
                dfs(grid,x,y); 
            }
        }
    }
}