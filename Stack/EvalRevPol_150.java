package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRevPol_150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();

        for(String token: tokens) {
            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {
                int num2 = st.pop();
                int num1 = st.pop();

                if (token.equals("+")) {
                    st.push(num1 + num2);
                } else if (token.equals("-")) {
                    st.push(num1 - num2);
                } else if (token.equals("*")) {
                    st.push(num1 * num2);
                } else {
                    st.push(num1 / num2);
                }
            } else {
                st.push(Integer.valueOf(token));
            }
        }

        return st.pop();
    }
}
