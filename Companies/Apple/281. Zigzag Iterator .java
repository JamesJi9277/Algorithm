public class ZigzagIterator {

    Iterator<Integer> iter1;
    Iterator<Integer> iter2;
    boolean first = true;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iter1 = v1.iterator();
        iter2 = v2.iterator();
    }

    public int next() {
        if (first) {
            if (iter1.hasNext()) {
                first = !first;
                return iter1.next();
            } else {
                first = !first;
                return iter2.next();
            }
        } else {
            first = !first;
            return iter2.hasNext() ? iter2.next() : iter1.next();
        }
    }

    public boolean hasNext() {
        return iter1.hasNext() || iter2.hasNext();
    }
}

public class ZigzagIterator {

    Iterator<Integer> iter1;
    Iterator<Integer> iter2;
    Deque<Iterator<Integer>> deque;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        deque = new LinkedList<>();
        iter1 = v1.iterator();
        iter2 = v2.iterator();
        if (iter1.hasNext()) {
            deque.offer(iter1);
        }
        if (iter2.hasNext()) {
            deque.offer(iter2);
        }
    }

    public int next() {
        if (!hasNext()) {
            return -1;
        }
        Iterator<Integer> temp = deque.pollFirst();
        int res = temp.next();
        if (temp.hasNext()) {
            deque.offer(temp);
        }
        return res;
    }

    public boolean hasNext() {
        return !deque.isEmpty();
    }
}