#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std ; 


class Solution {
    public:
        struct BIT {
            int n ; 
            vector<pair<int,int>> bit ; 
            BIT( int s ){
                n = s;  
                bit.assign( n+1 , {0,0} ) ; 
            }
            pair<int,int> getBest( int num ){
                int len = 0 ; 
                int rs = 0 ;
                while( num > 0 ){
                    if( bit[num].first > len ){
                        len = bit[num].first ; 
                        rs = bit[num].second ; 
                    }else if( bit[num].first == len ){
                        rs += bit[num].second ; 
                    }
                    num -= num&-num ; 
                }
                if( rs == 0 ){
                    return {0,1} ; 
                }
                return { len , rs } ; 
            }
            void update( int val ){
                pair<int,int> p = getBest( val-1 ) ; 
                int len = p.first+1 ; 
                int count  = p.second ; 
                while( val <= n ){
                    if( bit[val].first < len ){
                        bit[val].first = len ; 
                        bit[val].second = count ; 
                    }else if( bit[val].first == len ){
                        bit[val].second += count ; 
                    }
                    val += val & -val ; 
                }
            }
        };
        int findNumberOfLIS(vector<int>& nums) {
            int n = nums.size() ; 
            // index compression
            vector<pair<int,int>> m( n ) ; 
            for( int i=0 ; i<n ; ++i ){
                m[i] = { nums[i] , i } ; 
            }
            sort( m.begin() , m.end() ) ; 
            int curr = 1 ; 
            for( int i=0 ; i<n ; ++i ){
                nums[ m[i].second ] = curr ;  
                while( i+1<n && m[i+1].first == m[i].first ){
                    i++ ; 
                    nums[ m[i].second ] = curr ;             
                }
                curr++ ; 
            }
            BIT bit(curr) ; 
            for( int i=0 ; i<n ; ++i ){
                bit.update( nums[i] ) ; 
            }
            int rs = bit.getBest( curr ).second ; 
            return rs ; 
        }
    };