public class NestedIterator implements Iterator<Integer> {
    int index;
    List<Integer> res;
    public NestedIterator(List<NestedInteger> nestedList) {
        res = new ArrayList<>();
        index = 0;
        helper(nestedList, res);
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
        return res.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < res.size();
    }
}

public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger nest = stack.peek();
            if (nest.isInteger()) {
                return true;
            } else {
                stack.pop();
                for (int i = nest.getList().size() - 1; i >= 0; i--) {
                    stack.push(nest.getList().get(i));
                }
            }
        }
        return false;
    }
}
