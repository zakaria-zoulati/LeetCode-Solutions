#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    vector<int> countServers(int n, vector<vector<int>>& logs, int x, vector<int>& queries) {
        ios::sync_with_stdio(false);
        cin.tie(nullptr);
        cout.tie(nullptr);
        int m = logs.size(); 
        for( int i=0 ; i<m ; ++i ){
            swap( logs[i][0] , logs[i][1] );
        }
        sort( logs.begin() , logs.end() );
        
        int q = queries.size(); 
        vector<pair<int,int>> q_pair( q );
        for( int i=0 ; i<q ; ++i ){
            q_pair[i] = { queries[i] , i };
        }
        sort( q_pair.begin() , q_pair.end() );

        int count = 0 ;
        vector<int> f( n+1 , 0 ); 
        auto it1 = logs.begin() ; 
        auto it2 = logs.begin() ; 

        vector<int> ans(q);  

        for( int i=0 ; i<q ; ++i ){
            int l = q_pair[i].first - x ; 
            int r = q_pair[i].first ; 

            while( it2 != logs.end() && (*it2)[0] <= r ){
                if( f[(*it2)[1]]++ == 0 ) count++ ; 
                ++it2;
            }

            while( it1 != it2 && (*it1)[0] < l ){
                if( f[(*it1)[1]]-- == 1 ) count-- ; 
                ++it1;
            }

            ans[ q_pair[i].second ] = n-count;
        }
        return ans ; 
    }
};