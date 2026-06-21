class Solution {
public:
    vector<string> createGrid(int n, int m) {
       vector<string> grid( n , string(m,'#') ) ; 
       for( int i=0; i<m ; ++i ){
            grid[0][i] = '.' ; 
       }
       for( int i=0 ; i<n ; ++i ){
            grid[i][m-1] = '.' ; 
       }
       return grid ; 
    }
};