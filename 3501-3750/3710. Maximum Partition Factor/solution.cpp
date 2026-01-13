class Solution {
    public:
        int getCost( vector<vector<int>>& points , int i  , int j ) {
            return  abs( points[i][0] - points[j][0] ) + abs( points[i][1] - points[j][1] )  ; 
        } 
        bool helper( vector<vector<int>> &adj , int n ){
            vector<int> c(n,-1) ; 
            for( int i=0 ; i<n ; ++i ){
                if( c[i] != -1 ) continue ; 
                queue<int> q ; 
                q.push(i) ; 
                c[i] = 0 ; 
                while( !q.empty() ){
                    int node = q.front() ; 
                    q.pop() ; 
                    for( int v : adj[node] ){
                        if( c[v] == -1 ) {
                            c[v] = 1 - c[node] ; 
                            q.push(v) ; 
                        }else if( c[v] == c[node] ){
                            return false ; 
                        }
                    }
                }
            }
            return true ; 
        }
        bool check( vector<vector<int>>& points , int n , int tar ){
            vector<vector<int>> adj(n) ; 
            for( int i=0 ; i<n ; ++i ){
                for( int j=i+1 ; j<n ; ++j ){
                   if( getCost( points , i , j ) < tar ){
                       adj[i].push_back(j) ; 
                       adj[j].push_back(i) ; 
                   }
                }
            }
            return helper( adj , n ) ; 
        }
        int maxPartitionFactor(vector<vector<int>>& points) {
            int n = points.size() ; 
            if( n == 2 ) return 0 ; 
            if( n == 3 ) {
                int ans = 0 ; 
                for( int i=0 ; i<n ; ++i ){
                    for( int j=i+1 ; j<n ; ++j ){
                        ans = max( ans , getCost( points , i , j ) ) ; 
                    }
                }
                return ans ; 
            }
            int l = 0 ;
            int r = 2e9 ; 
            while( l < r ){
                int mid = l + ( r - l + 1 )/2 ; 
                if( check( points, n , mid ) ){
                    l = mid ; 
                }else {
                    r = mid - 1 ;
                }
            }
            return l ; 
        }
    };