import java.util.HashMap;
import java.util.Map;

class RansomNote3 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        preprocess(magazine, map);
        for(int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if(!map.containsKey(c)) {
                return false;
            } else if (map.get(c) == 0) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        return true;
    }

    private void preprocess(String magazine, Map<Character, Integer> map) {
        for(int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
    }

    public static void main(String[] args) {
        RansomNote3 obj = new RansomNote3();
        System.out.println(obj.canConstruct("b", "ba"));
    }
}