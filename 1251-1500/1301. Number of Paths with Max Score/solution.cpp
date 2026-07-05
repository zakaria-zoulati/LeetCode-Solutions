#include <bits/stdc++.h> 

using namespace std ; 

int dx[] = { 1 , 0 , 1 } ; 
int dy[] = { 0 , 1 , 1 } ; 

class Solution {
public:
    int score( char &c ){
        if( c == 'E' ){
            return 0 ; 
        }else {
            return c - '0' ; 
        }
    }
    vector<int> pathsWithMaxScore(vector<string>& board) {
        int n = board.size();
        int m = board[0].size();
        int mod = 1e9 + 7 ; 
        vector<vector<pair<int,int>>> dp( n , vector<pair<int,int>>(m,{0,0}) );
        dp[n-1][m-1].second = 1 ; 

        for( int i=m-2 ; i>=0; --i ){
            if( board[n-1][i] == 'X' ){
                break ; 
            }
            dp[n-1][i] = { dp[n-1][i+1].first + score( board[n-1][i] ) , 1 } ; 
        } 
        for( int i=n-2 ; i>=0 ; --i ){
            if( board[i][m-1] == 'X' ){
                break ; 
            }
            dp[i][m-1] = { dp[i+1][m-1].first + score( board[i][m-1] ) , 1 };   
        }

        for( int i=n-2 ; i>=0 ; --i ){
            for( int j=m-2 ; j>=0 ; --j ){
                if( board[i][j] != 'X' ){
                    int curr = score( board[i][j] ) ; 
                    for( int k=0 ; k<3 ; ++k ){
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if( dp[x][y].first != 0 || ( x == n-1 && y == m-1 ) ){
                            int can = dp[x][y].first + curr ;  
                            if( can == dp[i][j].first ){
                                dp[i][j].second = ( dp[i][j].second + dp[x][y].second ) % mod ; 
                            }else if( can > dp[i][j].first ){
                                dp[i][j] = { can , dp[x][y].second } ; 
                            }
                        }
                    }
                }
            }
        }
        return { dp[0][0].first , dp[0][0].second };
    }
};