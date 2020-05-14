package May;

public class LCCMaxDiffChangeInt {
    public int maxDiff(int num) {
        int a = calcA(num);
        int b = calcB(num);
        return a - b;
    }

    private int calcB(int num) {
        String n = String.valueOf(num);
        int i = 1;
        if(n.charAt(0) != '1') {
            return Integer.valueOf(n.replace(n.charAt(0), '1'));
        } else {
            while(i < n.length() && n.charAt(i) == '0') {
                i++;
            }
            String newNum;
            if(i == n.length()) {
                newNum = n;
            } else {
                newNum = n.replace(n.charAt(i), '0');
            }
            return Integer.valueOf(newNum);
        }
    }

    private int calcA(int num) {
        String n = String.valueOf(num);
        int i = 0;
        while(i < n.length() && n.charAt(i) == '9') {
            i++;
        }
        String newNum;
        if(i == n.length()) {
            newNum = n;
        } else {
            newNum = n.replace(n.charAt(i), '9');
        }
        return Integer.valueOf(newNum);
    }
}