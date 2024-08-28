class Solution {
    public void swap( int i , int j , String[] all ){
        String temp = all[i] ; 
        all[i] = all[j] ; 
        all[j] = temp ;  
    }   
    public String sortSentence(String s) {
        String[] all = s.split(" ") ; 
        int n = all.length ; 
            for( int i=0 ; i<n ; ++i ){
                while( i != all[i].charAt( all[i].length() -1 ) - '1'   ){
                     swap(  i ,  all[i].charAt( all[i].length() -1 ) - '1' , all  ) ; 
                }
            }
        
        StringBuilder rs = new StringBuilder() ; 
        for( String item : all ){
            rs.append(  item.substring( 0 , item.length() -1  )) ; 
            rs.append( " " ) ; 
        }

        return rs.toString().trim() ; 

    }
}