/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.index = 0;
        list = new ArrayList<>();
        helper(nestedList, list);
    }
    private void helper(List<NestedInteger> nested, List<Integer> list) {
        for (NestedInteger nest : nested) {
            if (nest.isInteger()) {
                list.add(nest.getInteger());
            } else {
                helper(nest.getList(), list);
            }
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */