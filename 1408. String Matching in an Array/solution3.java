class Solution {
    public List<String> stringMatching(String[] words) {
         String set = String.join(" " , words);
         List<String> rs  = new ArrayList<>();
         for(String i : words){
             if(set.indexOf(i) != set.lastIndexOf(i)){
                 rs.add(i);
             }
         }
         return rs;
     }
 }.