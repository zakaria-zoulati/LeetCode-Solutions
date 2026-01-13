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

        Set<Integer> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        
        int hash = 0;
        for (int i = 0; i < 10; i++) {
            hash = hash * 4 + val(s.charAt(i)); 
        }
        seen.add(hash);

        for (int i = 10; i < n; i++) {
            hash = (hash - val(s.charAt(i - 10)) * (1 << 18)); 
            hash = (hash << 2) + val(s.charAt(i)); 

            if (seen.contains(hash)) {
                String sequence = s.substring(i - 9, i + 1);
                repeated.add( sequence ) ; 
            } else {
                seen.add(hash);
            }
        }

        result.addAll(repeated);
        return result;
    }
}