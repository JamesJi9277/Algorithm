class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
    int[][] max = new int[m + 1][n + 1];
    for (int i = 0; i < strs.length; i++) {
        String str = strs[i];
        
        int neededZero = 0;
        int neededOne = 0;
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '0') {
                neededZero++;
            } else {
                neededOne++;
            }
        }
        
        int[][] newMax = new int[m + 1][n + 1];
        
        for (int zero = 0; zero <= m; zero++) {
            for (int one = 0; one <= n; one++) {
                if (zero >= neededZero && one >= neededOne) {
                    int zeroLeft = zero - neededZero;
                    int oneLeft = one - neededOne;
                    newMax[zero][one] = Math.max(1 + max[zeroLeft][oneLeft], max[zero][one]);
                } else {
                    newMax[zero][one] = max[zero][one];
                }
            }
        }
        
        max = newMax;
    }
    return max[m][n];
    }
}

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        List<Pair> list = new ArrayList<>();
        for (String s : strs) {
            list.add(transform(s));
        }
        List<Integer> res = new ArrayList<>();
        res.add(0);
        List<Pair> pairs = new ArrayList<>();
        helper(list, 0, res, pairs, m, n);
        return res.get(0);
    }
    private void helper(List<Pair> list, int index, List<Integer> res, List<Pair> pairs, int zero, int one) {
        if (zero < 0 || one < 0) {
            return;
        }
        if (!pairs.isEmpty() && res.get(0) < pairs.size()) {
            res.add(0, pairs.size());
        }
        for (int i = index; i < list.size(); i++) {
            pairs.add(list.get(i));
            helper(list, i + 1, res, pairs, zero - list.get(i).getZero(), one - list.get(i).getOne());
            pairs.remove(pairs.size() - 1);
        }
    }
    private Pair transform(String s) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zero++;
            } else {
                one++;
            }
        }
        return new Pair(zero, one);
    }
}
class Pair {
    int zero;
    int one;
    public Pair() {};
    public Pair(int i, int j) {
        this.zero = i;
        this.one = j;
    }
    public int getOne() {
        return this.one;
    }
    public int getZero() {
        return this.zero;
    }
    public void setOne(int one) {
        this.one = one;
    }
    public void setZero(int zero) {
        this.zero = zero;
    }
}