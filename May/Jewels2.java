package May;

public class Jewels2 {
    public int numJewelsInStones(String J, String S) {
        int identify[] = new int[128];
        J.chars().forEach(c -> identify[c] = 1);
        return (int)S.chars().filter(c -> identify[c] == 1).count();
    }
}