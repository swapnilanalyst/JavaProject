package JanPractice;

import java.util.HashMap;
import java.util.HashSet;

public class duplicateElementsInAarray {

    public static void main(String[] args) {

        String names[] = {"Java", "JavaScript", "C", "Python", "Ruby", "Java", "Java"};

        //1. Compare element with for loop but complexity will be On2 for large data comparison
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].equals(names[j])) {
                    System.out.println("Duplicate value is from for loop only :: " + names[i]);

                }
            }
        }

        //2. using HashSet
        HashSet<String> storeSet = new HashSet<String>();
        for (String name : names) {
            if (storeSet.add(name) == false) {
                System.out.println("Duplicate element is:: " + name);
            }
        }

        //3. Using hashMap with forEach lamda function:
        HashMap<String, Integer> storeMap = new HashMap<String, Integer>();
//        for (String name : names) {
//            Integer count = storeMap.get(name);
//            if (count == null) {
//                storeMap.put(name, 1);
//            } else {
//                storeMap.put(name, ++count);
//                System.out.println("Duplicate value is:: " + name + ":" + count);
//            }
//        }

        for (String a : names) {
            storeMap.put(a, storeMap.getOrDefault(a, 0) + 1);
        }

        storeMap.forEach((k, v) -> {
            if (v > 1) {
                System.out.println("Duplicate key:: " + k + " : " + v);
            }
        });


     //4.using hashmap with entryset:
        HashMap<String, Integer> storeMap2 = new HashMap<String, Integer>();
        for (String name : names) {
            Integer count = storeMap2.get(name);
            if (count == null) {
                storeMap.put(name, 1);
            } else {
                storeMap.put(name, ++count);
                System.out.println("Duplicate value is:: " + name + ":" + count);
            }
        }
    }
}
