class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        int[] mappings = new int[10];
        Arrays.fill(mappings, -1);
        mappings[0] = 0;
        mappings[1] = 1;
        mappings[6] = 9;
        mappings[8] = 8;
        mappings[9] = 6;
        char[] list = new char[n];
        helper(res, mappings, 0, n - 1, list);
        return res;
    }
    private void helper(List<String> res, int[] mappings, int left, int right, char[] temp) {
        if (left == right) {
            temp[left] = '0';
            res.add(new String(temp));
            temp[left] = '1';
            res.add(new String(temp));
            temp[left] = '8';
            res.add(new String(temp));
            return;
        } else if (left > right) {
            res.add(new String(temp));
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (mappings[i] == -1 || (left == 0 && i == 0)) {
                continue;
            }
            temp[left] = (char)(i + '0');
            temp[right] = (char)(mappings[i] + '0');
            helper(res, mappings, left + 1, right - 1, temp);
        }
    }
}