class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int biggestPile = 0;
        for (var pile : piles) {
            biggestPile=Math.max(pile, biggestPile);
        }

        int speed = biggestPile;
        int l = 1, r = speed;
        while(l <= r) {
            int midSpeed = (l+r+1)/2; // Ceiling.
            
            // Calculate hour.
            int hour = 0;
            for (var pile : piles) {
                hour += (pile + midSpeed - 1) / midSpeed;
            }
            
            if (hour <= h) {
                r = midSpeed-1;
                speed = Math.min(speed, midSpeed);
                continue;
            }
            l = midSpeed+1;
        }
        return speed;
    }
}