class Logger {

    Map<String, List<Integer>> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, new ArrayList<Integer>());
            map.get(message).add(timestamp);
            return true;
        } else {
            List<Integer> list = map.get(message);
            int recent = list.get(list.size() - 1);
            if (timestamp - recent < 10) {
                return false;
            } else {
                map.get(message).add(timestamp);
                return true;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */