class LCSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int i = 0, j = 0;
        int count = 0;
        
        while(i < text1.length() && j < text2.length()) {
            if(text1.charAt(i) == text2.charAt(j)) {
                j++; i++;
                count++;
            } else {
                i++;
            }
        }
        return count;
    }
}