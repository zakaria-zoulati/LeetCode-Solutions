class Solution {
  public String reverseWords(String s) {
    StringBuilder rs = new StringBuilder() ; 
    int n = s.length() ; 
    StringBuilder sb = new StringBuilder();
    for (int i = 0 ;i<n ; i++) { 
        if( s.charAt(i) == ' ' ){
            rs.append( " " ) ; 
            continue  ;
        }
        StringBuilder inter = new StringBuilder() ; 
        inter.append( s.charAt(i) ) ;
        while(i+1<n && s.charAt(i+1) != ' '){
            inter.append( s.charAt(i+1) ) ; 
            i++ ;
        }
        rs.append( inter.reverse() ) ; 
    }
    return rs.toString() ; 
  }
}
