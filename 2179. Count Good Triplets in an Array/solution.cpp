class Solution {
    public:
        struct BIT{
            int n ; 
            vector<int> bit ; 
            BIT( int len ){
                n = len ; 
                bit.assign( len + 1 , 0 ) ; 
            }
            int sum( int l , int r ){
                if( l > r ) return 0 ; 
                return get(r) - get(l-1) ; 
            } 
            int get( int idx ){
                int rs = 0 ; 
                while( idx > 0 ){
                    rs += bit[idx] ; 
                    idx -= idx & -idx ; 
                }
                return rs ; 
            }
            void update( int idx ){
                while( idx <= n ){
                    bit[idx]++ ; 
                    idx += idx & -idx ; 
                }
            }   
        } ;
        long long goodTriplets(vector<int>& nums1, vector<int>& nums2) {
            int n = nums1.size() ;
            vector<int> pos2(n) ; 
            for( int i=0 ; i<n ; ++i ){
                pos2[nums2[i]] = i ;  
            } 
            vector<int> arr(n); 
            for( int i=0 ; i<n ; ++i ){
                arr[i] = pos2[ nums1[i] ] + 1 ;  
            }
            long long rs = 0 ; 
            BIT bit(n) ;
            vector<int> left(n,0) ; 
            for( int i=0 ; i<n ; ++i ){
                left[i] = bit.sum( 1 , arr[i] - 1 ) ; 
                bit.update( arr[i] ) ; 
            }
            BIT bit2(n) ; 
            for( int i=n-1 ; i>=0 ; --i ){
                long long r = bit2.sum( arr[i] + 1 , n ) ; 
                rs += r*left[i] ; 
                bit2.update( arr[i] ) ; 
            }
    
            return rs ; 
        }
    };