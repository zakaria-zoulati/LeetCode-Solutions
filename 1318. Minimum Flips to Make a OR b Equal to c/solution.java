class Solution {
    public int minFlips(int a, int b, int c) {
        int rs = 0 ; 
        for(int i=0 ; i<32 ; ++i){
            if( ( c & 1 << i  ) == 0 ){
                if(  ( a & 1<< i )  != 0  ){
                    rs++ ; 
                } 
                if(  ( b & 1<< i )  != 0  ){
                    rs++ ; 
                } 
            }else {
                if(  ( a & 1<< i )  == 0 &&  ( b & 1 << i )  == 0    ){
                    rs++ ; 
                }
            }
        }
        return rs; 
    }
}