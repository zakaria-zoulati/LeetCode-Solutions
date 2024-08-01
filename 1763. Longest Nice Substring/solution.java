class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length() ; 
        if( n==1 ) return "" ; 
        StringBuilder rs = new StringBuilder() ; 
        // frequency array 
        int[][] min = new int[n][26] ; 
        int[][] maj = new int[n][26] ; 

        for(int i=0 ; i<n ; i++){
            if( i>0 ){
                for(int j=0 ; j<26 ; j++){
                    min[i][j] = min[i-1][j] ; 
                    maj[i][j] = maj[i-1][j] ; 
                }
            }
            int inter = (int) s.charAt(i) ; 
            if( inter >= 97 ){
                maj[i][ inter - 97 ]++ ;
            }else{
                 min[i][inter - 65 ]++ ;
            }
            
        }

        for(int i=n ; i>=2 ; i--){
            ok:for(int j=0 ; j+i<=n ; j++ ){
                if(j==0){
                    for(int k=0 ; k<26 ; k++){
                        if( min[j+i-1][k] != 0 && maj[j+i-1][k] ==0  ) continue ok ;
                        if( min[j+i-1][k] == 0 && maj[j+i-1][k] !=0  ) continue ok ;  
                    }
                }else {
                    for(int k=0 ; k<26 ; k++){
                        if( min[j+i-1][k] -  min[j-1][k] != 0 && maj[j+i-1][k] - maj[j-1][k] ==0  ) continue ok ;
                         if( min[j+i-1][k] -  min[j-1][k] == 0 && maj[j+i-1][k] - maj[j-1][k] !=0  ) continue ok ;
                    }
                }
                return s.substring(j , j+i) ; 
            }
        }
        return "" ; 

    }
}