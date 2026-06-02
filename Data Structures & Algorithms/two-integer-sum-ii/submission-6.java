class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int i = 0, j = numbers.length - 1;
    do {
      while (numbers[i] + numbers[j] > target) {
        j--;
      }
      while (numbers[i] + numbers[j] != target && numbers[i] + numbers[j] < target) {
        i++;
      }

      if (numbers[i] + numbers[j] == target) {
        return new int[]{i + 1, j + 1};
      }
    } while (i < j);
    return new int[]{};
  }
}
