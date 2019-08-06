package Arrays;

import java.awt.List;

// Given a set of time intervals in any order, merge all overlapping intervals into one and 
// output the result which should have only mutually exclusive intervals. Let the intervals be 
// represented as pairs of integers for simplicity.  

// For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. 
// The intervals {1,3} and {2,4} overlap with each other, so they should be merged and 
// become {1, 4}. Similarly {5, 7} and {6, 8} should be merged and become {5, 8}
public class MergeIntervals {

	/**
	 * Definition for an interval.
	 * public class Interval {
	 *     int start;
	 *     int end;
	 *     Interval() { start = 0; end = 0; }
	 *     Interval(int s, int e) { start = s; end = e; }
	 * }
	 */
	
	public List<Interval> merge(List<Interval> intervals) {
	    if (intervals.size() <= 1)
	        return intervals;
	    
	    // Sort by ascending starting point using an anonymous Comparator
	    // sort the interval objects based on their start time
	    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
	    
	    List<Interval> result = new Node<Interval>();	
	    int start = intervals.get(0).start;
	    int end = intervals.get(0).end;
	    
	    for (Interval interval : intervals) {
	        if (interval.start <= end) // Overlapping intervals, move the end if needed
	            end = Math.max(end, interval.end);
	        else {                     // Disjoint intervals, add the previous one and reset bounds
	            result.add(new Interval(start, end));
	            start = interval.start;
	            end = interval.end;
	        }
	    }
	    
	    // Add the last interval
	    result.add(new Interval(start, end));
	    return result;
	}
	
	
	
	
	
	// merge the given new interval into intervals
	//https://leetcode.com/problems/insert-interval/
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    List<Interval> result = new LinkedList<>();
	    int i = 0;
	    // add all the intervals ending before newInterval starts
	    while (i < intervals.size() && intervals.get(i).end < newInterval.start)
	        result.add(intervals.get(i++));
	    // merge all overlapping intervals to one considering newInterval
	    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
	        newInterval = new Interval(// we could mutate newInterval here also
            Math.min(newInterval.start, intervals.get(i).start),
            Math.max(newInterval.end, intervals.get(i).end));
	        i++;
	    }
	    result.add(newInterval); // add the union of intervals we got
	    // add all the rest
	    while (i < intervals.size()) result.add(intervals.get(i++)); 
	    return result;
	}
	
	
	
	// https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
	
	// 	http://www.learn4master.com/interview-questions/leetcode/leetcode-meeting-rooms-solution-in-java
	
	// http://www.learn4master.com/algorithms/leetcode-meeting-rooms-ii-java

}
