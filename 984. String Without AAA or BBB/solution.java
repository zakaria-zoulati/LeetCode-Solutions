class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder rs = new StringBuilder() ; 
        while( a+b >0 ){
            if( a == 0 ){
                rs.append('b') ; 
                --b; 
                continue ;
            }
            else if( b==0 ){
                rs.append('a') ; 
                --a ; 
                continue ;
            }
            if( a > b ){
                rs.append( "aa" ) ; 
                rs.append( "b" ) ; 
                a -= 2 ; 
                b-- ; 
            }else if( b > a ){
                rs.append( "bb" ) ; 
                rs.append( "a" ) ; 
                b -= 2 ; 
                a-- ; 
            }else {
                rs.append( "ab" ) ; 
                b-- ; 
                a-- ; 
            }
        }
        return rs.toString() ; 
    }
}