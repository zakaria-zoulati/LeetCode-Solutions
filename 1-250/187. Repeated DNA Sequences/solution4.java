/*

This is The Best Solution : Using One Fixied legngth Array And no Collections use ( Beats 98 % of Java Users )

*/

class Solution {
    public int val(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: throw new IllegalArgumentException("Invalid DNA character");
        }
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        
        if (n <= 10) {
            return result; 
        }

        int[] seen = new int[ 1_048_577 ] ; 
        
        int hash = 0;
        for (int i = 0; i < 10; i++) {
            hash = hash * 4 + val(s.charAt(i)); 
        }
        seen[hash] = 1  ; 

        for (int i = 10; i < n; i++) {
            hash = (hash - val(s.charAt(i - 10)) * (1 << 18)); 
            hash = (hash << 2) + val(s.charAt(i)); 

            if ( seen[hash] == 1 ) {
                String sequence = s.substring(i - 9, i + 1);
                result.add( sequence ) ; 
                seen[hash] = 2  ;
            } else if( seen[hash] == 0 )  {
                seen[hash] = 1 ;
            }
        }

        return result;
    }
}