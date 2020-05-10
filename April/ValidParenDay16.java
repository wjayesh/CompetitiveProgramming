package April;

public class ValidParenDay16 {
    public static boolean checkValidString(String s) {
        int i = 0, j = s.length() - 1;
        
        while(i != j) {
            boolean check = checkComplements(s.charAt(i), s.charAt(j));
            if(check == false) {
                return false;
            }
            i++; j--;
        }
        return true;
    }

    private static boolean checkComplements(char c1, char c2) {
        
        switch(c1) {
            case '(':
            if (c2 == ')' || c2 == '*')
            return true;
            case ')':
            if (c2 == '(' || c2 == '*')
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("((*))"));
    }

}