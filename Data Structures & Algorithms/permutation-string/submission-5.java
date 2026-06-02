class Solution {
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) return false;

    // Init target maps
    Map<Character, Integer> tMap = new HashMap<>();
    Map<Character, Integer> wMap = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      // Target.
      tMap.computeIfAbsent(s1.charAt(i), k -> 0);
      tMap.compute(s1.charAt(i), (k, v) -> v + 1);

      // Window.
      wMap.computeIfAbsent(s2.charAt(i), k -> 0);
      wMap.compute(s2.charAt(i), (k, v) -> v + 1);
    }

    // Init scores.
    int tScore = tMap.size();
    int wScore = 0;
    for (var entry : wMap.entrySet()) {
      if (tMap.get(entry.getKey()) != null && tMap.get(entry.getKey()) == entry.getValue()) wScore++;
    }
    if (wScore == tScore) return true;

    int l = 1, r = l + s1.length() - 1;
    while (r <= s2.length() - 1) {
      System.out.println(s2.substring(l, r + 1));

      // Take care left.
      wMap.compute(s2.charAt(l - 1), (k, v) -> v - 1);
      if (tMap.get(s2.charAt(l - 1)) != null) {
        if (tMap.get(s2.charAt(l - 1)) == wMap.get(s2.charAt(l - 1))) {
          System.out.println("Receive + from left");
          wScore++;
        } else if (tMap.get(s2.charAt(l - 1)) - 1 == wMap.get(s2.charAt(l - 1))) {
          wScore--;
        }
      }

      // Take care right.
      wMap.computeIfAbsent(s2.charAt(r), k -> 0);
      wMap.compute(s2.charAt(r), (k, v) -> v + 1);
      if (tMap.get(s2.charAt(r)) != null) {
        if (tMap.get(s2.charAt(r)) == wMap.get(s2.charAt(r))) {
          System.out.println("C: " + s2.charAt(r) + " - V: " + wMap.get(s2.charAt(r)));
          System.out.println("Receive + from right");
          wScore++;
        } else if (tMap.get(s2.charAt(r)) + 1 == wMap.get(s2.charAt(r))) {
          wScore--;
        }
      }

      System.out.println("Target: " + tScore);
      System.out.println("Window: " + wScore);

      System.out.println("");
      System.out.println("");

      // Validate score.
      if (tScore == wScore) return true;
      l++;
      r++;
    }
    return false;
  }
}
