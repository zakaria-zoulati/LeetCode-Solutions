class Solution {
    public int bits(int n){
        int count = 0 ; 
        while( n!=0 ){
            if( (n&1) ==1 ){
                count++ ;
            }
            n  >>= 1 ;  
        }
        return count ; 
    }
    public int countPrimeSetBits(int left, int right) {
        HashSet<Integer> set = new HashSet<>() ; 
        ok : for(int i=2 ; i<=31 ;++i){
            for(int j=2 ;j*j<=i ; j++){
                if( i % j== 0 ){
                    continue ok ;  
                }
            }
            set.add(i) ; 
        }
        int rs = 0 ;
        for(int i= left ; i<=right ; i++){
            if( set.contains( bits(i) ) ) rs++ ;
        } 
        return rs ; 

    }
}