package May;

class RansomNote3 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[128];
        magazine.chars().forEach(c -> counts[c]++);
        return ransomNote.chars().allMatch(c -> counts[c]-- > 0);
    }

    public static void main(String[] args) {
        RansomNote3 obj = new RansomNote3();
        System.out.println(obj.canConstruct("b", "ba"));
    }
}