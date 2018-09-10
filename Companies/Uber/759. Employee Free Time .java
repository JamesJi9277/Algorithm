class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        List<Interval> res1 = new ArrayList<>();
        for (List<Interval> list : schedule) {
            res.addAll(list);
        }
        Collections.sort(res, (a, b) -> (a.start - b.start));
        int end = res.get(0).end;
        for (Interval i : res) {
            if (i.start > end) {
                res1.add(new Interval(end, i.start));
            }
            end = Math.max(end, i.end);
        }
        return res1;
    }
}