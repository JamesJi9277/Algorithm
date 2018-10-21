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

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp1 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NestedInteger temp = queue.poll();
                if (temp.isInteger()) {
                    temp1.add(temp.getInteger());
                } else {
                    queue.addAll(temp.getList());
                }
            }
            res.add(new ArrayList<Integer>(temp1));
        }
        int depth = res.size();
        int sum = 0;
        for (List<Integer> temp : res) {
            for (int i : temp) {
                sum += i * depth;
            }
            depth--;
        }
        return sum;
    }
}