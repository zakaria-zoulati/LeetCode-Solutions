class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++) {   
            String s=String.valueOf(i);
            int len=s.length();
            if( (len & 1) == 0 ){
                if(  symmetric(s)){
                    count++;
                    i += 8  ; 
                }
            }else{
                i = next(s) ; 
            }
        }
        return count;
    }
    public int next(String s){
        int len = s.length() ; 
        int rs = 0 ;
        for(int i=0 ; i<len ; ++i){
            rs += Math.pow(10,i) ;
        }
        return rs*9 ; 
    }
    public boolean symmetric(String s)
    {
        int len=s.length();
        int mid=len/2;
        int s1=0,s2=0;
        for (int i=0;i<mid;i++)
        {
            s1+=s.charAt(i)-'0'; 
            s2+=s.charAt(len-i-1)-'0';
        }
        return s1==s2;
    }
}