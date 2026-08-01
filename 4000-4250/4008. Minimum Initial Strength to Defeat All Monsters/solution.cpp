#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    long long minInitialStrength(vector<int>& monsters, vector<vector<int>>& boosts) {
        int n = monsters.size(); 
        int m = boosts.size(); 

        vector<long long> diff(n,0) ; 
        for( int i=0 ; i<m ; ++i ){
            int l  = boosts[i][0] ;
            int r  = boosts[i][1] ;
            int v  = boosts[i][2] ;
            diff[l] += v  ;
            if( r+1<n ){
                diff[r+1] -= v ; 
            }
        }
        for( int i=1 ; i<n ; ++i ){
            diff[i] += diff[i-1] ; 
        }

        
        long long ans = max( 0LL , (long long ) monsters[n-1] - diff[n-1] ) ; 
        for( int i=n-2 ; i>=0 ; --i ){
            long long curr = diff[i] - monsters[i] ; 
            if( ans == 0 ){
                ans = max( 0LL , (long long) monsters[i] - diff[i] ) ; 
            }else {
                ans += monsters[i] ; 
            }
        }
        return ans ; 
    }
};