class StringIterator {

    String s;
    int head;
    int tail;
    int count;
    public StringIterator(String compressedString) {
        s = compressedString;
        head = 0;
        tail = 0;
        count = 0;
    }
    
    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        if (count == 0) {
            head = tail++;
            while (tail < s.length() && Character.isDigit(s.charAt(tail))) {
                tail++;
            }
            count = Integer.parseInt(s.substring(head + 1, tail));
        }
        count--;
        return s.charAt(head);
    }
    
    public boolean hasNext() {
        return count > 0 || tail < s.length();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */