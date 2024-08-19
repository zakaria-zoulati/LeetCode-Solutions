class Solution {
    public int minPartitions(String n) { 
        for(int i=9 ; i>=2 ; --i){
            if( n.contains( String.valueOf(i) ) ){
                return i ;
            }
        }
        return 1 ;
    }
}