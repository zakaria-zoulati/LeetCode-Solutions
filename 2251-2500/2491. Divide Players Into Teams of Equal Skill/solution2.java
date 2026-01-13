class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length ; 
        int sum = 0 ; 
        int[] com = new int[1001] ;
        for(int num : skill ){
            sum += num ; 
            com[num]++ ; 
        }
        int g = n/2 ; 
        if( sum % g != 0 ){
            return -1 ; 
        }
        int target = sum/g ; 
        long rs = 0L ; 
        for(int i=1 ; i <= Math.min( target/2 , 1000 )  ; ++i ){
            if( target - i >= 1001 || com[i] == 0  ) continue ; 
            if( com[i] != com[target-i] ){
                return -1 ; 
            }
            if( i == target -i ){
                rs += (long) com[i]*( i )*( target - i )/2 ; 
            }else {
                 rs += (long) com[i]*( i )*( target - i ) ; 
            }
        }
        return rs ; 
    }
}