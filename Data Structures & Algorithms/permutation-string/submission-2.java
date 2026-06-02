class Solution {
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
        return false;
    }

    // Init map1.
    Map<Character, Integer> map1 = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      var c = s1.charAt(i);
      map1.computeIfAbsent(c, (key) -> 0);
      map1.compute(c, (key, value) -> value + 1);
    }

    // Init map2.
    Map<Character, Integer> map2 = new HashMap<>();
    for (int j = 0; j < s1.length(); j++) {
      var c = s2.charAt(j);
      map2.computeIfAbsent(c, (key) -> 0);
      map2.compute(c, (key, value) -> value + 1);
    }

    int score = 0;
    for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
      var c = entry.getKey();
      var cCount = entry.getValue();
      if (map2.get(c) != null && map2.get(c) == cCount) {
        score++;
      }
    }
    if (score == map1.size()) {
      return true;
    }

    int l = 0, r = l + s1.length() - 1;

    while (l + 1 <= s2.length() - s1.length()) {
      // Handle left.
      var lChar = s2.charAt(l);
      map2.compute(lChar, (key, value) -> value - 1);
      if (map1.get(lChar) != null) {
        int countMap1 = map1.get(lChar);
        if (countMap1 == map2.get(lChar)) {
          score++;
        } else if (countMap1 == map2.get(lChar) + 1) {
          score--;
        }
      }
      l++;

      // Handle right.
      r++;
      var rChar = s2.charAt(r);
      map2.computeIfAbsent(rChar, (key) -> 0);
      map2.compute(rChar, (key, value) -> value + 1);
      if (map1.get(rChar) != null) {
        int countMap1 = map1.get(rChar);
        if (countMap1 == map2.get(rChar)) {
          score++;
        } else if (countMap1 == map2.get(rChar) - 1) {
          score--;
        }
      }

      if (score == map1.size()) {
        return true;
      }
    }
    return false;
  }
}
