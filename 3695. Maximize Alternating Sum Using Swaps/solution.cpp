#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std ; 

class Solution {
    public:
        long long rs = 0 ; 
        void dfs( int node , vector<vector<int>> &edges , vector<bool> &seen , vector<int> &nums ){
            vector<int> vals ; 
            int pair = 0 , impair = 0 ; 
            queue<int> q ; 
            seen[node] = true ; 
            q.push(node) ; 
            while( !q.empty() ){
                 int node = q.front() ;
                 q.pop() ; 
                 if( node % 2 == 0 ){
                     pair++ ; 
                 }else {
                     impair++ ; 
                 }
                 vals.push_back( nums[node] ) ; 
                 for( int v : edges[node] ){
                    if( !seen[v] ){
                        q.push(v) ; 
                        seen[v] = true ; 
                    }
                 }
            }
            long long curr = 0 ; 
            sort( vals.begin() , vals.end() ) ; 
            int in = vals.size()-1 ; 
            while( pair-- > 0 ){
                curr += vals[in--] ; 
            }
            while( impair-- > 0 ){
                curr -= vals[in--] ; 
            }
            rs += curr ; 
        }
        long long maxAlternatingSum(vector<int>& nums, vector<vector<int>>& swaps) {
            int n = nums.size() ; 
            vector<vector<int>> edges(n) ; 
            for( vector<int> &s : swaps ){
                int u = s[0] ; 
                int v = s[1] ; 
                edges[u].push_back(v) ; 
                edges[v].push_back(u) ; 
            }
            vector<bool> seen(n,false) ; 
            for( int i=0 ; i<n ; ++i ){
                 if( !seen[i] ){
                     dfs( i , edges , seen , nums ) ; 
                 }   
            }
            return rs ; 
        }
    };