class Solution {
    // public int Pow(int n ){
    //     int rs =1 ;
    //     while(n>=10){
    //         rs++ ;
    //         n = n/10 ; 
    //     }
    //     return rs  ;
    // }
    public int compress(char[] chars) {
        int current = 0 ;
        int n = chars.length ; 
        int rs  = 0 ;
        for(int i=0; i<n ; i++){
            rs++ ;
            int a = 1 ;
            chars[current]  = chars[i] ;
            current++ ;
            while(i+1 < n && chars[i]==chars[i+1]){    
                i++ ;
                a++ ;      
            }
            
            if(a>1){
                int inter =1 ;
                String rel = String.valueOf(a) ;
                chars[current] = rel.charAt(0) ;
                current++ ;
                while(a>=10){
                    inter++ ;
                    a = a/10 ; 
                    chars[current] = rel.charAt(inter-1) ;
                    current++ ;
                }
                rs = rs+inter ; 
            }
        }
        return rs  ;
    }
}