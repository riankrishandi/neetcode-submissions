class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = piles[0];
        for (int i = 1; i < piles.length; i++) {
            maxSpeed = Math.max(maxSpeed, piles[i]);
        }

        // BST from l = 1, r = maxSpeed;
        int res = 0, l = 1, r = maxSpeed;
        while (l <= r) {
            int speed = (l + r) / 2;

            int totalH = 0;
            for (int pile : piles) {
                totalH += (pile + speed - 1) / speed;
            }

            if (totalH <= h) {
                res = speed;
                r = speed - 1;
            } else {
                l = speed + 1;
            }
        }
        return res;
    }
}