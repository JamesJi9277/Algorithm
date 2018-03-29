class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return res;
        }
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            // 这里的其实是一个关键，相当于也是不用考虑末端的0
            for (int j = res.size() - 2; j >= 0; j--) {
                // 这里是set而不是add
                // 因为是要override
                res.set(j + 1, res.get(j) + res.get(j + 1));
            }
            res.add(1);
        }
        return res;
    }
}