package homeWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class CollectionJ {

	public static void main(String[] args) {
		int[] s = { 1, 2, 2, 5, 5, 6, 3, 5 };

		Map<Integer, Integer> map = new HashMap();

		for (Integer ch : s) {

			if (map.containsKey(ch)) {

				map.put(ch, map.get(ch) + 1);
			} else {

				map.put(ch, 1);
			}
		}

//		System.out.println(map);

		Set<Entry<Integer, Integer>> entry = map.entrySet();

		for (Entry<Integer, Integer> e : entry) {

			if (e.getValue() >= 1) {

				System.out.println(e.getKey() + ": " + e.getValue());
			}
		}

	}

}
