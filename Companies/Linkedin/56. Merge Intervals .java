class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, (a, b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            } else {
                return a.start - b.start;
            }
        });
        for (Interval i : intervals) {
            if (res.size() == 0 || res.get(res.size() - 1).end < i.start) {
                res.add(i);
            } else {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, i.end);
            }
        }
        return res;
    }
}