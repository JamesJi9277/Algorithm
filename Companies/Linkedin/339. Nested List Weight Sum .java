class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        int sum = 0;
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nest = queue.poll();
                if (nest.isInteger()) {
                    sum += depth * nest.getInteger();
                } else {
                    queue.addAll(nest.getList());
                }
            }
            depth++;
        }
        return sum;
    }
}

class Solution {
    int sum = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        helper(nestedList, 1);
        return sum;
    }
    private void helper(List<NestedInteger> nested, int depth) {
        for (NestedInteger nest : nested) {
            if (nest.isInteger()) {
                sum += nest.getInteger() * depth;
            } else {
                helper(nest.getList(), depth + 1);
            }
        }
    }
}

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        List<List<Integer>> res = new ArrayList<>();
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
        int level = 1;
        for (List<Integer> list : res) {
            for (int i : list) {
                sum += level * i;
            }
            level++;
        }
        return sum;
    }
}