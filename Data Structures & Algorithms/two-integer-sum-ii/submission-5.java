class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int adjustment = 0;
        if (numbers[0] < 0) {
            adjustment = numbers[0] * -1;
        }

        int i = 0, j = numbers.length - 1;
        do {
            while (numbers[i] + numbers[j] + 2 * adjustment > target + 2 * adjustment) {
                j--;
            } 
            while (numbers[i] + numbers[j] + 2 * adjustment != target + 2 * adjustment && numbers[i] + numbers[j] + 2 * adjustment < target + 2 * adjustment) {
                i++;
            }

            if (numbers[i] + numbers[j] + 2 * adjustment == target + 2 * adjustment) {
                return new int[]{i + 1, j + 1};
            }
        } while (i < j);
        return new int[]{};
    }
}
