class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (var str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            // Parse string size;
            int size = Integer.parseInt(str.substring(i, j));

            // #Parse the text.
            int start = j+1;
            int end = start+size;
            res.add(str.substring(start, end));

            i = end;
        }
        return res;
    }
}
