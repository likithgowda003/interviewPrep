package Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class amazon1 {
	List<List<Integer>> optimalUtilization(
            int deviceCapacity,
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList)
    {
        int curMax = 0;

        TreeMap<Integer, List<List<Integer>>> sortedCapacityMap = new TreeMap<Integer, List<List<Integer>>>();
        // find memory occupied by each foreground process with every other backgorund process
        for(List<Integer> foregroundApp : foregroundAppList) {
            for(List<Integer> backgorundApp : backgroundAppList) {
                int totalMemory = foregroundApp.get(1) + backgorundApp.get(1);

                // if memory occupied is less thamn or equal to total capacity, add it to tree map
                if(totalMemory <= deviceCapacity){
                    int foregroundAppId = foregroundApp.get(0);
                    int backgorundAppId = backgorundApp.get(0);
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.add(foregroundAppId, backgorundAppId);

                    if(sortedCapacityMap.containsKey(totalMemory)){
                        List<List<Integer>> tempList = sortedCapacityMap.get(totalMemory);
                        tempList.add(newList);
                        sortedCapacityMap.put(totalMemory, tempList);
                    }
                    else {
                        List<List<Integer>> tempList = new ArrayList<List<Integer>>();
                        tempList.add(newList);
                        sortedCapacityMap.put(totalMemory, tempList);
                    }
                }
            }
        }

        int lastKey = sortedCapacityMap.lastKey();
        List<List<Integer>> result = sortedCapacityMap.get(lastKey);
        return result;
    }
}
