package com.huststl.year18.dec.day24;



import java.util.*;


public class Main056 {

    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    //解法1
    public List<Interval> merge(List<Interval> intervals) {
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<>();
        // j is start of interval.
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }

    //解法2
    public List<Interval> merge01(List<Interval> intervals) {
        List<Interval> list = new ArrayList<Interval>();
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        };
        Collections.sort(intervals, comparator);
        for (Interval interval : intervals)
            if (list.size() == 0 || list.get(list.size() - 1).end < interval.start)
                list.add(new Interval(interval.start, interval.end));
            else
                list.get(list.size() - 1).end = Math.max(interval.end, list.get(list.size() - 1).end);
        return list;
    }



}