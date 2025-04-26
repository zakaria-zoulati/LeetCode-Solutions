class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        int n = responses.size(); 
        HashMap<String , Integer > map = new HashMap<>(); 
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; ++i) { 
            for (String s : responses.get(i)) {
                if ( !set.contains(s) ) {
                    map.put( s, map.getOrDefault(s, 0) + 1);
                    set.add( s ); 
                }
            }
            set.clear();
        }
        int max = 0; 
        String rs = ""; 
        for (String i : map.keySet()) {
            if (map.get(i) > max) {
                max = map.get(i);
                rs = i;
            } else if(map.get(i) == max) {
                if (i.compareTo(rs) < 0) { 
                    rs = i ;
                }
            }
        }
        return rs; 
    }
}
