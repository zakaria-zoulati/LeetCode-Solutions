class Solution {
public:
    vector<int> parent ; 


    int find( int x ){
        if( parent[x] == x ) return x;  
        return parent[x] = find( parent[x] ) ; 
    } 

    int unionSet( int a , int b ){
        int pa=find(a) ; 
        int pb=find(b) ;

        if( pa == pb ) return true ; 
        parent[pa] = pb ;
        return false ;
    }

    bool containsCycle(vector<vector<char>>& grid) {
        int n = grid.size() , m = grid[0].size() ; 
        parent.resize(n*m) ;

        for( int i=0 ; i<n*m ; ++i ) parent[i] = i ; 

        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                int id = i * m + j ; 
                if( j + 1 < m && grid[i][j] == grid[i][j+1] ){
                    if( unionSet(id,  i * m + (j+1) ) ) return true ; 
                }
                if( i + 1 < n && grid[i][j] == grid[i+1][j] ){
                    if( unionSet(id, (i+1)*m + j ) ) return true ; 
                }
            }
        }
        return false ; 
    }
};