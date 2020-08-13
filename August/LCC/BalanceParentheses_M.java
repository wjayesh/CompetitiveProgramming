
class Solution {
    public int minInsertions(String s) {
        int count = 0, res = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ')' && st.isEmpty()) {
                st.push(i);
            } else if(s.charAt(i) == ')' && st.peek() != i + 1) {
                st.push(i);
            } else if(s.charAt(i) == ')') {
                if(!st.isEmpty()) st.pop();
                count++;
            }
            if(s.charAt(i) == '(') {
                count--;
                if(count < 0) {
                    if(st.isEmpty()) {
                        res += 2;
                    } else {
                        res += 1;
                        st.pop();
                    }
                    count = 0;
                }
            }
        }
        res = res + st.size() * 2;
        return count == 0? res : res + count;
    }
}
