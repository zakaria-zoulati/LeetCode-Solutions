class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int n = grid.size() ; 
        int m = grid[0].size() ; 
        int ans = 0 ; 
        int col = m ; 
        for( int i=0 ; i<n ; ++i ){
            while( col > 0 && grid[i][col-1] < 0 ){
                col-- ; 
            }
            ans += m - col; 
        }
        return ans; 
    }
};