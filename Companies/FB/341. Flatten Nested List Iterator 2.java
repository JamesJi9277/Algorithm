public class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        index = 0;
        helper(nestedList, list);
    }
    
    private void helper(List<NestedInteger> nestedInteger, List<Integer> list) {
        for (NestedInteger nest : nestedInteger) {
            if (nest.isInteger()) {
                list.add(nest.getInteger());
            } else {
                helper(nest.getList(), list);
            }
        }
    }

    @Override
    public Integer next() {
        if (index > list.size()) {
            return null;
        }
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}