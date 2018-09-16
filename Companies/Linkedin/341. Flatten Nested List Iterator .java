public class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        index = 0;
        list = new ArrayList<>();
        helper(nestedList, list);
    }
    private void helper(List<NestedInteger> nestedList, List<Integer> list) {
        for (NestedInteger nest : nestedList) {
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