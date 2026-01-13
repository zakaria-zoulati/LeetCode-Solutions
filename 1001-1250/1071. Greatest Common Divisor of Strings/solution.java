class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n = str1.length() ; 
        int m = str2.length() ; 
        if( n > m  ){
            for(int i=m ; i>=1 ; --i){
                if( n%i == 0 && m%i == 0 ){
                    if(str1.equals( str2.substring(0,i).repeat( n/i ))  && str2.equals( str1.substring(0,i).repeat( m/i ) ) ){
                        return  str2.substring(0,i) ;
                    }
                }
            }
            return "" ; 
        }else {
            for(int i=n ; i>=1 ; --i){
                if( m%i == 0 && n%i==0 ){
                    if(  str1.equals( str2.substring(0,i).repeat( n/i )) && str2.equals( str1.substring(0,i).repeat( m/i ) )   ){
                        return  str1.substring(0,i) ;
                    }
                }
            }
            return "" ;
        }
    }
}