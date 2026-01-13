class Solution {
    public String getSmallestString(String s) {
        int n = s.length() ; 
        StringBuilder rs = new StringBuilder() ; 
        boolean flag = true ;
        for(int i=0 ; i<n ; ++i){
            int a = s.charAt(i) - '0' ;
            if( flag && i+1<n ){
                int b = s.charAt(i+1) - '0' ;
                if( b<a &&  (a-b) % 2 == 0  ){
                        rs.append(b) ;  
                        rs.append( a ) ;
                        i++ ;  
                        flag = false ; 
                        continue ; 
                } 
            }
            rs.append(a) ; 
        }

        return rs.toString() ; 

    }
}