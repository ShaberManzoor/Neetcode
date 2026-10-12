package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack_155 {
    Deque<Integer> s;
    int min = Integer.MAX_VALUE;

    public MinStack_155() {
        s = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(val <= min){          
            s.push(min);
            min=val;
        }
        s.push(val);
    }
    
    public void pop() {
        if(s.pop() == min) min=s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}
