package Stack;

import java.util.Arrays;

public class CarFleet_853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n==1) return 1;
        
        int[][] cars = new int[n][2];

        for(int i=0;i<n;i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a,b) -> Integer.compare(b[0], a[0]));

        int fleets = 0;
        double lastTime = 0;
        for(int car[]: cars) {
            int pos = car[0], sp = car[1];
            double arr = (double) (target - pos) / sp;

            if(arr>lastTime) {
                fleets++;
                lastTime = arr;
            }
        }

        return fleets;
    }
}
