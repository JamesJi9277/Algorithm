class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int sum = 0;
        int level = 1;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nest = queue.poll();
                if (nest.isInteger()) {
                    sum += nest.getInteger() * level;
                } else {
                    queue.addAll(nest.getList());
                }
            }
            level++;
        }
        return sum;
    }
}

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }
    private int helper(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                sum += nest.getInteger() * level;
            } else {
                sum += helper(nest.getList(), level + 1);
            }
        }
        return sum;
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