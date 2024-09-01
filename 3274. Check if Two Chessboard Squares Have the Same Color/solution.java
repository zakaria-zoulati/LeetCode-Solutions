class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int first = coordinate1.charAt(0) - 'a' ; 
        int second = coordinate2.charAt(0) - 'a' ; 
        int a  = ( coordinate1.charAt(1) - '1'  )-(coordinate2.charAt(1) - '1') ; 
        if(  ( second - first ) % 2 == 0  ){
            System.out.println("ok") ; 
            return (  (a+8) % 2 == 0  ) ;
        }else {
            System.out.println("ok2") ;
             return (  (a+8) % 2 == 1 ) ;
        }
    }
}