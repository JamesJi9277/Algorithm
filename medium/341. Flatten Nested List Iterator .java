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

    List<Integer> res;
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        res = new ArrayList<Integer>();
        index = 0;
        convert(nestedList, res);
    }
    
    private void convert(List<NestedInteger> nestedList, List<Integer> res) {
        for (NestedInteger integer : nestedList) {
            if (integer.isInteger()) {
                res.add(integer.getInteger());
            } else {
                convert(integer.getList(), res);
            }
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return res.get(index++);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return index < res.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */