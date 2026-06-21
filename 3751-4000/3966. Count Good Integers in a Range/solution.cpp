#include <bits/stdc++.h>


using namespace std ; 

using ll = long long ;
using vll = vector<ll>; 
using vvll = vector<vll> ; 
using vvvll = vector<vvll> ; 

ll dp[19][10][2]; 

class Solution {
public:
    ll solve( ll n, int d ){
        memset( dp , 0 , sizeof dp ) ; 

        vector<int> digits;
        while( n > 0 ){
            digits.push_back( n % 10 ) ; 
            n /= 10; 
        }
        int len = digits.size() ; 
        
        for( int i=0 ; i<=9 ; ++i ){
            dp[0][i][0] = 1 ; 
        }
        for( int i=0 ; i<=digits[0] ; ++i ){
            dp[0][i][1] = 1 ; 
        }

        for( int i=1 ; i<len ; ++i ){
            for( int j=0 ; j<=9 ; ++j ){
                for( int k=0; k<=9 ; ++k ){
                    if( abs(j-k) <= d ){
                        dp[i][j][0] += dp[i-1][k][0] ; 
                    }
                }
            }

            for( int j=0 ; j<digits[i] ; ++j ){
                for( int k=0 ; k<=9 ; ++k ){
                    if( abs( j - k ) <= d ){
                        dp[i][j][1] += dp[i-1][k][0] ; 
                    }
                }
            }

            for( int k=0 ; k<=9 ; ++k ){
                if( abs( digits[i] - k ) <= d ){
                    dp[i][ digits[i] ][1] += dp[i-1][k][1] ; 
                }
            }
        }

        ll ans = 0 ; 
        for( int i=1; i<=9 ; ++i ){
            ans += dp[len-1][i][1] ; 
        } 

        for( int i=0 ; i<len-1 ; ++i ){
            for( int j=1 ; j<=9 ; ++j ){
                ans += dp[i][j][0] ; 
            }
        }
        return ans; 
    }
    ll goodIntegers(ll l, ll r, int k) {
        ll ans = solve( r , k ) - solve( l-1 , k ) ; 
        return ans; 
    }
};