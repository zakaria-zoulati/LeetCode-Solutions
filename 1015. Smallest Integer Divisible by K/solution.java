class solution {
    public int smallestRepunitDivByK(int k) {
       if( k % 2 == 0 || k % 5 == 0 ){
            return -1 ; 
       }
       int len = 1 ; 
       int curr = 1%k ; 
       while( curr != 0 ){
            curr = ( curr*10 + 1 )%k ; 
            len++ ; 
       } 
       if( curr != 0 ){
            return  -1 ; 
       }
       return len ; 
    }
}