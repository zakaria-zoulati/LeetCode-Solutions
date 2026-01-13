class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n%2!=0) return false;
        int[] stack = new int[n] ; 
        int nec = -1 ; 
        int[] opt = new int[n] ; 
        int op = -1 ; 
        for(int i=0;i<n;++i){
            char state = locked.charAt(i);
            if(state == '0'){
               opt[++op] = i ; 
               continue ; 
            }
            char ch = s.charAt(i);
            if(ch == '('){
                stack[++nec] = i ; 
            }else{ 
                if(nec != -1){
                    --nec ; 
                }else{
                    if(op != -1){
                        --op ; 
                    }else{
                        return false;
                    }
                }
            }
        }
        if(nec > op){
            return false ; 
        }
        while( nec >= 0 && stack[nec] < opt[op]){
            --nec ; --op ; 
        }
        return nec == -1 ;
    }
}