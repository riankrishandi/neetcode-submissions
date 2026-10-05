class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str + "+?");
        }
        System.out.println("Encoded: " + sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> res = new ArrayList<>();
        do {
            int idx = str.indexOf("+?", i);
            if (idx == -1) break;

            if (i == idx) {
                res.add("");
            } else {
                res.add(str.substring(i, idx));
            }

            i = idx + 2;
        } while (i < str.length());
        return res;
    }
}
