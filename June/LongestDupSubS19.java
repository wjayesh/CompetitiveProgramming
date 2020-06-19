class LongestDupSubS19 {
    public String longestDupSubstring(String S) {
        int max = 0;
        String seq = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++) {
            if(map.containsKey(S.charAt(i))) {
                int len = compare(i, map, S);
                if(len > max) {
                    max = len;
                    seq = S.substring(i, i + len);
                }
            } else {
                map.put(S.charAt(i), i);
            }
        }
        return seq;
    }
    
    private int compare(int i, HashMap<Character, Integer> map, String s) {
        char c = s.charAt(i);
        int j = map.get(c), len = 0;
        while(i < s.length() && j < s.length() && s.charAt(i) == s.charAt(j)) {
            len++; i++; j++;
        }
        return len;
    }
}
