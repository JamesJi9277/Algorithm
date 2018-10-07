class Solution {
    public int minTransfers(int[][] transactions) {
        if (transactions == null || transactions.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.putIfAbsent(t[0], 0);
            map.putIfAbsent(t[1], 0);
            map.put(t[0], map.get(t[0]) - t[2]);
            map.put(t[1], map.get(t[1]) + t[2]);
        }
        int res = Integer.MAX_VALUE;
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                positive.add(entry.getValue());
            } else if (entry.getValue() < 0) {
                negative.add(entry.getValue());
            }
        }
        Stack<Integer> pStack;
        Stack<Integer> nStack;
        for (int j = 0; j < 1000; j++) {
            int count = 0;
            pStack = new Stack<>();
            nStack = new Stack<>();
            for (int i : positive) {
                pStack.push(i);
            }
            for (int i : negative) {
                nStack.push(i);
            }
            while (!negative.isEmpty()) {
                int neg = nStack.pop();
                int pos = pStack.pop();
                count++;
                if (pos == -neg) {
                    continue;
                } else if (pos > -neg) {
                    pStack.push(pos + neg);
                } else {
                    nStack.push(pos + neg);
                }
            }
            res = Math.min(res, count);
            Collections.shuffle(positive);
            Collections.shuffle(negative);
        }
        return res;
    }
}