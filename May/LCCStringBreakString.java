package May;

import java.util.Arrays;

public class LCCStringBreakString {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        s1 = String.valueOf(s1Arr);
        s2 = String.valueOf(s2Arr);
        return doesBreak(s1, s2) || doesBreak(s2, s1);
    }

    private boolean doesBreak(String s1, String s2) {
        for(int i = 0; i < s1.length(); i++) {
            if(!(s1.charAt(i) >= s2.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LCCStringBreakString obj = new LCCStringBreakString();
        System.out.println(obj.checkIfCanBreak("abc", "xya"));
    }
}