class Solution {
    public int minimumRounds(int[] tasks) {
        int rs = 0; 
        int n = tasks.length ; 
        int current = 0 ; 
        Arrays.sort(tasks) ;
        for(int i=0; i<n ;++i){
            current++ ; 
            while( i+1<n && tasks[i]==tasks[i+1] ){
                i++; 
                current++ ;
            }
            if( current == 1 ){
                return -1 ;
            }
            else {
               if( current == 4 || current==5  ){
                    rs +=2 ; 
               }else {
                    rs += current/3 + ( current %3 !=0 ? 1: 0 ) ; 
               }
            }
            current = 0 ; 
        }
        return rs ; 
    }
}