class Solution {
    public:
        struct BIT {
            vector<int> bit ; 
            int n; 
            BIT( vector<int> &nums , int len){
                n = len ;  
                bit.assign(n+1,0) ; 
                for( int i=2 ; i<len ; ++i ){
                    if( nums[i-1] > nums[i-2] && nums[i-1] > nums[i] ){
                        updateIdx( i , 1 ) ; 
                    }
                }
            }
            int getIdx( int idx ){
                int rs = 0 ; 
                while( idx > 0 ){
                    rs += bit[idx] ; 
                    idx -= idx & -idx ; 
                }
                return rs ; 
            }
            int get(int l , int r){
                if( r - l  < 2 ) return 0 ;    
                return getIdx(r-1) - getIdx(l) ; 
            }
            void update( vector<int> &nums , int i , int val ){
                if( i-1>1 && nums[i-3]<nums[i-2] ){
                    int d = ( nums[i-2] > nums[i-1] ? -1 : 0 ) + ( nums[i-2]>val ? 1 :0 ) ; 
                    if( d != 0 ) updateIdx(i-1,d) ; 
                }
                if( i+1<n && nums[i] > nums[i+1] ){
                    int d = ( nums[i] > nums[i-1] ? -1 : 0 ) + ( nums[i] > val ? 1 : 0 ) ; 
                    if( d != 0 ) updateIdx( i+1,d ) ; 
                }
                if( i > 1 && i < n ){
                    int d = ( nums[i-2] < nums[i-1] && nums[i] < nums[i-1] ? -1 : 0 ) + 
                    ( nums[i-2] < val && nums[i]  < val ? 1 : 0 ) ;
                    if( d != 0 ) updateIdx( i , d) ; 
                }
                nums[i-1] = val ; 
            }
            void updateIdx( int idx , int diff ){
                while( idx <= n ){
                    bit[idx] += diff ; 
                    idx += idx & -idx ; 
                }
            }
        };
        vector<int> countOfPeaks(vector<int>& nums, vector<vector<int>>& queries) {
            int n = nums.size() ; 
            vector<int> rs ; 
            BIT bit( nums , n ) ; 
            for( auto &q : queries ){ 
                if( q[0] == 1 ){
                    rs.push_back(bit.get( q[1] + 1 , q[2] + 1 )); 
                }else {
                    bit.update( nums , q[1]+1 , q[2] ) ; 
                }
            }
            return rs ; 
        }
    };