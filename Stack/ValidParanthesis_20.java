package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParanthesis_20 {
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                dq.push(c);
            } else {
                if (dq.isEmpty()) return false;

                char top = dq.peek();

                if (c == ')' && top == '(' ||
                    c == '}' && top == '{' ||
                    c == ']' && top == '[') {
                    dq.pop();
                } else {
                    return false;
                }
            }
        }

        return dq.isEmpty();
    }
}
