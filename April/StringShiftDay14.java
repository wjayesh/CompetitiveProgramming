import java.util.*;

public class StringShiftDay14 {
    public static String stringShift(String s, int[][] shift) {
        LinkedList<Character> deque = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            deque.add(s.charAt(i));
        }
        for(int i = 0; i < shift.length; i++) {
            int[] command = shift[i];
            switch(command[0]) {
                case 0:
                shiftLeft(deque, command[1]);
                break;
                case 1:
                shiftRight(deque, command[1]);
                break;
            }
        }
        Iterator<Character> it = deque.iterator();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < deque.size(); i++) {
            builder.append(it.next());
        }

        return builder.toString();
    }

    private static void shiftRight(LinkedList<Character> deque, int i) {
        while(i != 0) {
            char last = deque.removeLast();
            deque.addFirst(last);
            i--;
        }
    }

    private static void shiftLeft(LinkedList<Character> deque, int i) {
        while(i != 0) {
            char first = deque.removeFirst();
            deque.addLast(first);
            i--;
        }
    }
    public static void main(String[] args) {
        String s = "abcdefg";
        int[][] arr = new int[][]{{1, 1, 0, 1}, {1, 1, 2, 3}};
        stringShift(s, arr);
    }
}