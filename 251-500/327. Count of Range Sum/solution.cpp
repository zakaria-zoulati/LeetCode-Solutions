#include <bits/stdc++.h>

using namespace std; 

class Solution {
public:
    struct BIT{
        int n ; 
        vector<int> bit;  
        BIT( int n ) : n(n) , bit( n , 0 ) {}

        void insert( int idx ){
            while( idx < n ){
                bit[ idx ]++ ; 
                idx += idx & -idx; 
            }
        }

        int query( int idx ){
            int ans = 0 ; 
            while( idx > 0 ){
                ans += bit[ idx ] ; 
                idx -= idx & -idx ; 
            }
            return ans; 
        }

        int range( int a , int b ){
            return query(b) - query(a-1) ; 
        }
    };

    int countRangeSum(vector<int>& nums, int lower, int upper) {
        int n = nums.size();

        vector<long long> vals;
        long long pref = 0 ; 
        for( int num : nums ){
            pref += num; 
            vals.push_back(pref);
            vals.push_back(pref-lower);
            vals.push_back(pref-upper);
        }
        sort( vals.begin() , vals.end() );
        vals.erase( unique( vals.begin() , vals.end() ) , vals.end() ); 

        unordered_map<long long,int> m ;
        int counter = 1 ; 
        for( long long num : vals ){
            m[num] = counter ; 
            counter++ ; 
        }    

        int ans = 0 ;
        BIT bit( counter ) ; 
        pref = 0;  
        for( int num : nums ){
            pref += num ; 
            if( lower <= pref && pref <= upper ){
                ans++ ; 
            }
            ans += bit.range( m[pref-upper] , m[pref-lower] ); 
            bit.insert( m[pref] ) ;  
        }
        return ans; 
    }
};