class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            String temp = s.substring(i, i + 2);
            if (temp.equals("++")) {
                StringBuffer sb = new StringBuffer();
                sb.append(s.substring(0, i));
                sb.append("--");
                sb.append(s.substring(i + 2));
                res.add(new String(sb));
            }
        }
        return res;
    }
}