class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int i = 0, j = numbers.length - 1;
    if (numbers[j] + numbers[j - 1] < target) {
        return new int[]{};
    }

    while (i < j) {
        int sum = numbers[i] + numbers[j];
        if (sum == target) {
            return new int[]{i+1, j+1};
        }
        if (sum > target) {
            j--;
            continue;
        }
        i++;
    }
    return new int[]{};
  }
}
