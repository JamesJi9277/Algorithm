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


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NestedInteger nest = queue.poll();
                if (nest.isInteger()) {
                    list.add(nest.getInteger());
                } else {
                    queue.addAll(nest.getList());
                }
            }
            res.add(list);
        }
        int weight = res.size();
        for (List<Integer> list : res) {
            for (int i : list) {
                sum += i * weight;
            }
            weight--;
        }
        return sum;
    }
}