#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    vector<int> lexicographicallySmallestArray(vector<int>& nums, int limit) {
        int n = nums.size() ; 
        
        vector<pair<int,int>> coords(n);
        for( int i=0 ; i<n ; ++i ){
            coords[i] = { nums[i] , i } ; 
        }
        sort( coords.begin() , coords.end() );

        vector<int> rep(n);
        iota( rep.begin() , rep.end() , 0 ); 

        for( int i=1 ; i<n ; ++i ){
            if( coords[i].first - coords[i-1].first <= limit ){
                rep[i] = rep[i-1] ; 
            }
        }

        for( int i=0 ; i<n ; ++i ){
            vector<int> positions ; 
            positions.push_back( coords[i].second );

            int start = i ; 
            int end = i ; 
            while( i+1<n && rep[i+1] == rep[i] ){
                i++ ;
                positions.push_back( coords[i].second ); 
            }
            end = i;
            sort( positions.begin() , positions.end() );
            for( int j=start ; j<=end; ++j ){
                nums[ positions[j-start] ] = coords[j].first; 
            } 
        }   
        return nums; 
    }   
};