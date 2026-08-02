class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeSet<int[]> carFleets = new TreeSet<>((a, b)-> b[0] - a[0]);
        for (int i = 0; i < position.length; i++) {
          carFleets.add(new int[]{position[i], speed[i]});
        }

        int[] lastFleet = new int[]{0, 0};
        int totalFleet = 0;

        for (int[] cf : carFleets) {
          if (lastFleet[1] == 0) {
            lastFleet[0] = cf[0];
            lastFleet[1] = cf[1];
            continue;
          }
          
          double currentTime = (double) (target - cf[0])/cf[1];
          double lastTime = (double) (target - lastFleet[0])/lastFleet[1];

          if (currentTime <= lastTime) {
            lastFleet[0] = Math.max(cf[0], lastFleet[0]);
            lastFleet[1] = Math.min(cf[1], lastFleet[1]);
          } else {
            lastFleet[0] = cf[0];
            lastFleet[1] = cf[1];
            totalFleet++;
          }
        }
        return lastFleet[1] != 0 ? totalFleet + 1 : 0;
    }
}
