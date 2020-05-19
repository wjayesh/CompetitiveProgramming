package May;

import java.util.ArrayList;
import java.util.List;

public class LCCReformatString {
    public String reformat(String s) {
        if(s == null || s.length()<=1)
            return s; 
        List<Character> digits = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)) digits.add(c);
            else chars.add(c);
        }
        if(Math.abs(digits.size()-chars.size()) >= 2) return "";
        
        StringBuilder sb = new StringBuilder();
        boolean digitOrChar = (digits.size()>=chars.size()) ? true : false; 
        for(int i = 0; i<s.length(); i++){
            if(digitOrChar)
                sb.append(digits.remove(0));
            else
                sb.append(chars.remove(0));
            digitOrChar = !digitOrChar; 
        }
        return sb.toString(); 
    } 
}