
class ConvertStringKmoves_M {
  public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int diff = (t.charAt(i) - s.charAt(i) + 26) % 26;
            if (diff > 0 && diff + count[diff] * 26 > k) {
                return false;
            }
            ++count[diff];
        }
        return true;
    }
}

/**
* Check if the 2 strings s and t have same length, if not, return false;
Loop through the input strings and count the shift displacement, in case negative, plus 26 to make it positive;
If same displacement appears multiple times, the 1st time use the displacement itself, the 2nd time add 26to it, the 3rd time add 26 * (3 - 1) = 52, the 4th time add 26 * (4 - 3) = 78, etc.; if after adding the result is greater than k, return false;
If never encounter false in the above 3, return false.
**/
