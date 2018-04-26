class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        while (--k > 0) {
            list = nextPermutation(list);
        }
        StringBuffer sb = new StringBuffer();
        for (int i : list) {
            sb.append(i + "");
        }
        return sb.toString();
    }
    private List<Integer> nextPermutation(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }
        int i;
        int j;
        for (i = list.size() - 2; i >= 0; i--) {
            if (list.get(i) < list.get(i + 1)) {
                break;
            } else if (i == 0) {
                doReverse(list, 0, list.size() - 1);
            }
        }
        for (j = list.size() - 1; j >= 0; j--) {
            if (list.get(i) < list.get(j)) {
                break;
            }
        }
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
        doReverse(list, i + 1, list.size() - 1);
        return list;
    }
    private void doReverse(List<Integer> list, int start, int end) {
        for (int i = 0; start + i < end - i; i++) {
            int temp = list.get(start + i);
            list.set(start + i, list.get(end - i));
            list.set(end - i, temp);
        }
    }
}