// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    List<Integer> list;
    int index = 0;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (!hasNext()) {
            return null;
        }
        return list.get(index);
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
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

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Integer next = null;
    Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        if (iterator.hasNext()) {
            next = iterator.next();
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = next;
        next = (iterator.hasNext() ? iterator.next() : null);
        return res;
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	}
}