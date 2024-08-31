class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int count = 1;
        for (String item : sentence.split(" ")) {
            if (item.startsWith(searchWord)) return count;
            count++;
        }
        return -1;
    }
}
