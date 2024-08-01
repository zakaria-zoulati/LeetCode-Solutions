class Solution {
    public int countSeniors(String[] details) {
        int rs = 0 ; 
        int n = details.length ; 
        for(int i=0 ; i<n ; i++ ){
            if( Integer.parseInt( details[i].substring(11,13) )  > 60 )  rs++ ;
        }
        return rs ; 
    }
}