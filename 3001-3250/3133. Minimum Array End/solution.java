class Solution {
    public long minEnd(int n, int x) {
        long rs=0L; 
        int clone=x; 
        int[] rep = new int[64] ; 
        for(int i=0;i<32;++i){
            rep[i]=(clone&1) ; 
            clone>>=1; 
        } 
        int ins=n-1; 
        for( int i=0 ; i<64 && ins>0 ; ++i ){
            if(rep[i]==0){
                rep[i]=(ins&1) ; 
                ins>>=1; 
            }
        }
        for(int i=0;i<64;++i){
            rs += ((long) rep[i] << i); 
        }
        return rs ;
    }
}