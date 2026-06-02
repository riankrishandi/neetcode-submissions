class Solution {
    public String encode(List<String> strs) {
      var sb = new StringBuilder();
      for (var str : strs) {
        sb.append(str.length()).append("#").append(str);
      }
      return sb.toString();
    }

    public List<String> decode(String str) {
      int i = 0;
      List<String> res = new ArrayList<>();
      while (i < str.length()) {
        // Parse the integer.
        int j = i;
        while (str.charAt(j) != '#') {
          j++;
        }

        // Parse size of the string.
        int size = Integer.parseInt(str.substring(i, j));

        i = j + 1;
        j = i + size;
        res.add(str.substring(i, j));

        i = j;
      }
      return res;
    }
}
