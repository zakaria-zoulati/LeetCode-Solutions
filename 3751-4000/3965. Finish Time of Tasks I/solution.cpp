#include <bits/stdc++.h>

using namespace std; 

class Solution {
public:
    long long finishTime(int n, vector<vector<int>>& edges, vector<int>& baseTime) {
        
        if( n == 1 ){
            return baseTime[0]; 
        }
        
        map<int,int> parent ; 
        vector<bool> isLeaf( n , true ) ; 
        vector<long long> time(n,-1) ; 
        vector<int> childs( n , 0 ) ; 

        
        for( int i=0 ; i<n-1 ; ++i ){
            int ui = edges[i][0] ; 
            int vi = edges[i][1] ; 
            parent[vi] = ui ; 
            childs[ui]++ ; 
            isLeaf[ui] = false ; 
        }
        queue<int> q ; 
        
        vector<pair<long long , long long>> times( n , { LLONG_MIN , LLONG_MAX } ) ;
        for( int i=0 ; i<n ; ++i ){
            if( isLeaf[i] && i != 0 ){
                q.push(i) ; 
                time[i] = baseTime[i] ; 
                times[i] = { baseTime[i] , baseTime[i] } ; 
            }
        }

        while( !q.empty() ){
            int len = q.size() ; 
            for( int i=0 ; i<len ; ++i ){
                int curr = q.front() ; 
                q.pop() ; 
                if( !isLeaf[curr] ){
                    time[curr] = baseTime[curr] + ( times[curr].first - times[curr].second ) + times[curr].first ;   
                }
                if( parent.find(curr) != parent.end() ){
                    times[parent[curr]].first = max( times[parent[curr]].first , time[curr] ) ; 
                    times[parent[curr]].second = min( times[parent[curr]].second , time[curr] ) ; 
                    if( --childs[ parent[curr] ] == 0 ){
                        q.push( parent[curr] ) ; 
                    }
                }
            }
        }
        return time[0] ; 
    }
};