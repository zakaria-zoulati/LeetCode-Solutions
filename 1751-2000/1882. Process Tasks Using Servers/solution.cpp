#include <bits/stdc++.h>

using namespace std;  
using ll = long long;

class Solution {
public:
    vector<int> assignTasks(vector<int>& servers, vector<int>& tasks) {
        int n = servers.size();
        int m = tasks.size();
        priority_queue<pair<ll,ll>> pq ;
        priority_queue<pair<ll,ll>> processing ; 
        for( int i=0 ; i<n ; ++i ){
            pq.push( { 0 , -1LL*servers[i]*1'000'000 - i } ); 
        }

        vector<int> ans(m);
        for( int i=0 ; i<m ; ++i ){
            while( !processing.empty() && -processing.top().first <= i ){
                auto [t,val] = processing.top();
                processing.pop(); 
                pq.push( { 0 , val } );  
            }   
            if( !pq.empty() ){
                auto [t,val] = pq.top();
                pq.pop() ; 
                ans[i] = (-val) % 1'000'000 ; 
                processing.push( { -max( -t , i*1LL ) - tasks[i] , val } ); 
            }else {
                auto [t,val] = processing.top();
                processing.pop() ; 
                ans[i] = ( -val ) % 1'000'000 ; 
                processing.push( { -max( -t , i*1LL ) - tasks[i] , val } ) ; 
            }
        }
        return ans; 
    }
};