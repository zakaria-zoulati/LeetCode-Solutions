#include <bits/stdc++.h>

using namespace std; 

class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {
        vector<vector<pair<int,int>>> edges( n+1 );
        for( auto &r : roads ){
            edges[r[0]].push_back( {r[1],r[2]} );
            edges[r[1]].push_back( {r[0],r[2]} );
        }
        

        int ans = INT_MAX ; 
        vector<bool> seen(n+1,false);
        seen[1] = true; 

        queue<int> q ; 
        q.push(1);

        while( !q.empty() ){
            int node = q.front();
            q.pop();
            for( auto &[v,d] : edges[node] ){
                ans = min( ans , d ) ; 
                if( !seen[v] ){
                    seen[v]=true;
                    q.push( v ); 
                }
            }
        }   
        return ans ;
    }
};