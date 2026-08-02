class Solution {
  public int carFleet(int target, int[] position, int[] speed) {
    // Sort by position.
    // Index 0 is position. Index 1 is speed.
    TreeSet<int[]> sortCars = new TreeSet<>((a, b) -> b[0] - a[0]);
    for (int i = 0; i < position.length; i++) {
      int[] car = new int[]{position[i], speed[i]};
      sortCars.add(car);
    }

    // Count car fleet.
    int carFleet = 0;
    int[] currentFleet = new int[2];
    // Loop through cars.
    for (var car : sortCars) {
      if (currentFleet[1] == 0) {
        currentFleet[0] = car[0];
        currentFleet[1] = car[1];
        continue;
      }

      float carTime = (float) (target - car[0])/car[1];
      float fleetTime = (float) (target - currentFleet[0])/currentFleet[1];
      if (carTime <= fleetTime) {
        int speedMin = Math.min(car[1], currentFleet[1]);
        currentFleet[0] = Math.max(car[0], currentFleet[0]);
        currentFleet[1] = speedMin;
      } else {
        carFleet++;
        currentFleet[0] = car[0];
        currentFleet[1] = car[1];
      }
    }
    return carFleet + (currentFleet[1] != 0 ? 1 : 0);
  }
}