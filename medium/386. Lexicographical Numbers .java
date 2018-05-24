class Solution {
    public List<Integer> lexicalOrder(int n) {
        if (n < 1) {
            return new ArrayList<Integer>();
        }
        int cur = 1;
        List<Integer> res = new ArrayList<Integer>();
        while (res.size() < n) {
            res.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else if (cur % 10 != 9 && cur + 1 <= n) {
                cur++;
            } else {
                while ((cur / 10) % 10 == 9) {
                    cur /= 10;
                }
                // 这里的一个处理很机智
                // 实际上是保留到了十位数
                // 然后再进行取最高处理,并且同时考虑到了13的处理
                cur = cur / 10 + 1;
            }
        }
        return res;
    }
}