package Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class amazon {
	public static List<List<Integer>> optimalUtilization(int deviceCapacity, List<List<Integer>> foregroundAppList, List<List<Integer>> backgroundAppList) {

        TreeMap<Integer, List<List<Integer>>> sortedCapacityMap = new TreeMap<Integer, List<List<Integer>>>();

        System.out.println("in");
        // find memory occupied by each foreground process with every other backgorund process
        for (List<Integer> foregroundApp : foregroundAppList) {
            for (List<Integer> backgorundApp : backgroundAppList) {
                int totalMemory = foregroundApp.get(1) + backgorundApp.get(1);

                // if memory occupied is less than or equal to total capacity, add it to tree map
                if (totalMemory <= deviceCapacity) {
                		System.out.println(totalMemory);
                    int foregroundAppId = foregroundApp.get(0);
                    int backgorundAppId = backgorundApp.get(0);
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.add(foregroundAppId);
                    newList.add(backgorundAppId);

                    if (sortedCapacityMap.containsKey(totalMemory)) {
                        List<List<Integer>> tempList = sortedCapacityMap.get(totalMemory);
                        tempList.add(newList);
                        sortedCapacityMap.put(totalMemory, tempList);
                    } else {
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


    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> list3 = new ArrayList<Integer>();

        List<List<Integer>> list11 = new ArrayList<List<Integer>>();
        list1.add(1);
        list1.add(8);
        list2.add(2);
        list2.add(7);
        list3.add(3);
        list3.add(14);
        list11.add(list1);
        list11.add(list2);
        list11.add(list3);


        List<Integer> nlist1 = new ArrayList<Integer>();
        List<Integer> nlist2 = new ArrayList<Integer>();
        List<Integer> nlist3 = new ArrayList<Integer>();

        List<List<Integer>> list22 = new ArrayList<List<Integer>>();
        nlist1.add(1);
        nlist1.add(5);
        nlist2.add(2);
        nlist2.add(10);
        nlist3.add(3);
        nlist3.add(14);
        list22.add(nlist3);
        list22.add(nlist2);
        list22.add(nlist1);


        List<List<Integer>> res = optimalUtilization(20, list11, list22);
        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }
}	
