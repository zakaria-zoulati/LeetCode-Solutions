class Solution {
    public:
        void backtrack( vector<int> &rods , int in ,  int s1 , int s2 , 
        map<int,pair<int,int>> &diff ){
            if( in == (int) rods.size() ){
                if( s1 > diff[s1 - s2].first ){
                    diff[s1-s2] = { s1 , s2 } ; 
                }
                return ; 
            }
            backtrack( rods , in+1 , s1 + rods[in] , s2 , diff ) ;
            backtrack( rods , in+1 , s1 , s2 + rods[in] , diff ) ;
            backtrack( rods , in+1 , s1 , s2 , diff ) ;
        }
        int tallestBillboard(vector<int>& rods) {
            int n = rods.size() ; 
            vector<int> v1 , v2 ; 
            for( int i=0 ; i<n/2 ; ++i ){
                v1.push_back(rods[i]) ; 
            }
            for(int i=n/2 ; i<n ; ++i){
                v2.push_back(rods[i]) ; 
            }
            map<int,pair<int,int>> diff1 , diff2 ; 
            backtrack( v1 , 0 , 0 , 0 , diff1 ) ;
            backtrack( v2 , 0 , 0 , 0 , diff2 ) ;
            int rs = 0 ; 
            for( auto &[k,v] : diff1 ){
                if( diff2.count(k) ){
                    rs = max( rs , v.first + diff2[k].second ) ; 
                }
            }
            return rs ; 
        }
    };