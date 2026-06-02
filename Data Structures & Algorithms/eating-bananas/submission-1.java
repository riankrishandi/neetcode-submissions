class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int i = 0; i < piles.length; i++) {
            maxPile = Math.max(maxPile, piles[i]);
        }

        // Find min h.
        int minK = maxPile;
        int l = 1, r = maxPile;
        while (l <= r) {
            int speed = (l+r)/2;

            // Get total hour.
            int totalHour = 0;
            for (var pile : piles) {
                totalHour += (pile + speed - 1) / speed; 
            }

            if (totalHour > h) {
                l = speed + 1;
            } else {
                minK = Math.min(minK, speed);
                r = speed - 1;
            }
        }

        return minK;
    }
}