#include <iostream>
#include <vector>
#include <algorithm>

using namespace std ; 
using ll = long long  ; 
#define all(x) begin(x) , end(x)

class Solution {
public:
    ll  maximumTotalDamage(vector<int>& power) {
        sort( all(power) ) ; 
        int n = power.size() ; 
        vector<int> spells  ; 
        vector<ll> count  ; 
        vector<ll> pref ; 
        for( int i=0 ; i<n ; ++i ){
            spells.push_back(i) ;
            ll curr = 1 ; 
            while( i+1<n && power[i+1] == power[i] ){
                i++ ; 
                curr++ ; 
            }
            count.push_back(curr) ; 
        }
        int d = spells.size() ; 
        if( d == 1 ){
            return count[0]*power[0] ; 
        }else if( d == 2 ){
            if( power[n-1] - power[0]  > 2 ){
                return count[0]*power[0] + count[1]*power[n-1];  
            }else {
                return max( count[0]*power[0] , count[1]*power[n-1] ) ;
            }
        }else {
            ll ans = -1 ; 
            vector<ll> dp( d ) ; 
            dp[0] = count[0]*power[0] ; 
            pref.push_back( dp[0] ) ; 
            ans = dp[0] ; 
            if(  power[spells[1]] - power[ spells[0] ] > 2 ){
                dp[1] = dp[0] + power[spells[1]]*count[1] ; 
            }else {
                dp[1] = power[spells[1]]*count[1] ; 
            }
            pref.push_back( max( dp[0] , dp[1] ) ) ; 
            ans = max( ans , dp[1] ) ; 
            for( int i=2 ; i<d ; ++i ){
                if( power[spells[i]] -  power[spells[0]] <= 2 ){
                    dp[i] = power[spells[i]]*count[i] ; 
                }else if( power[spells[i]] - power[spells[i-1]] > 2 ) {
                     dp[i] = power[spells[i]]*count[i] + pref[i-1] ;  
                }else if( power[spells[i]] - power[spells[i-2]] > 2 ){
                    dp[i] = power[spells[i]]*count[i] + pref[i-2] ;
                }else {
                    dp[i] = power[spells[i]]*count[i] + pref[i-3] ;
                }
                ans = max( ans , dp[i] ) ; 
                pref.push_back( max( dp[i] , pref[i-1] ) ) ; 
            }
            return ans ; 
        } 
    }
};