package dsa.problems.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-anagrams
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getKey(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                ArrayList<String> group = new ArrayList<>();
                group.add(str);
                map.put(key, group);
            }
        }

        return new ArrayList<>(map.values());
    }

    private String getKey(String str) {
        char[] key = str.toCharArray();
        Arrays.sort(key);
        return new String(key);
    }
}
