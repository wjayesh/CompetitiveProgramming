package May;

public class FirstUnique5 {
    public int firstUniqChar(String s) {
        char letters[] = new char[128];
        s.chars().forEach(c -> letters[c]++);
        for(int i = 0; i < s.length(); i++) {
            if(letters[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;       
    }
}