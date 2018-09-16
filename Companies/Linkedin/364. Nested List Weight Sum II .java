class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NestedInteger nest = queue.poll();
                if (nest.isInteger()) {
                    temp.add(nest.getInteger());
                } else {
                    queue.addAll(nest.getList());
                }
            }
            res.add(temp);
        }
        int sum = 0;
        int level = res.size();
        for (List<Integer> list : res) {
            for (int i : list) {
                sum += level * i;
            }
            level--;
        }
        return sum;
    }
}