package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangle_84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>(); //MONO INCREASE
        int maxArea = 0;
        
        for(int i=0;i<=n;i++) {
            int currHeight = (i==n) ? 0 : heights[i];

            while(!st.isEmpty() && currHeight<heights[st.peek()]) {
                int height = heights[st.pop()];

                int width;
                if(st.isEmpty()) {
                    width = i;
                } else {
                    width = i - st.peek() - 1;
                }

                int area = height * width;
                maxArea = Math.max(area, maxArea);
            }

            st.push(i);
        }

        return maxArea;
    }
}
