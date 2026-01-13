class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length ; 
        int rs = 0 ; 
        for(int i=1 ; i<travel.length ; ++i){
            travel[i] += travel[i-1] ; 
        }
        int p = 0 ; 
        int g = 0; 
        int m = 0; 
        int curr = 0 ; 
        for( String item : garbage ){
            if( item.indexOf('P') != -1 ){
                p = curr ; 
            }
            if( item.indexOf('G') != -1 ){
                g = curr ; 
            }
            if( item.indexOf('M') != -1 ){
                m = curr ; 
            }
            rs += item.length() ; 
            curr++ ; 
        }
        if( p>0 ){
            rs += travel[p-1] ; 
        }
        if( g>0 ){
            rs += travel[g-1] ; 
        }
        if( m>0 ){
            rs += travel[m-1] ; 
        }
        return rs ; 
    }
}