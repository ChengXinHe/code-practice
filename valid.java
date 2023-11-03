import java.util.*;

public class valid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(isValid(s));
        }
    }

    public static boolean isValid(String s) {
        Map<Character, Character> m = new HashMap<>(); //cuo le
        m.put(')', '('); //cuo le
        m.put(']', '[');
        m.put('}', '{');

        Deque<Character> dq = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                dq.offerFirst(c);
            }
            else {
                if (dq.peek() == m.get(c)) {
                    dq.poll();
                } else {
                    return false;
                }
            }
        }

        return dq.size() == 0;
    }
}