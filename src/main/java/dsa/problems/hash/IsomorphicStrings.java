package dsa.problems.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/isomorphic-strings
public class IsomorphicStrings {
    public boolean isIsomorphicOriginal(String s, String t) {
        List<List<Integer>> structureS = new ArrayList<>(getStructure(s).values());
        List<List<Integer>> structureT = new ArrayList<>(getStructure(t).values());
        return structureS.equals(structureT);
    }

    private Map<Character, List<Integer>> getStructure(String word) {
        Map<Character, List<Integer>> structure = new LinkedHashMap<>();

        char[] characters = word.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            structure.computeIfAbsent(characters[i], k -> new ArrayList<>()).add(i);
        }

        return structure;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);

            if (mapST.containsKey(ss) && mapST.get(ss) != tt) {
                return false;
            }
            if (mapTS.containsKey(tt) && mapTS.get(tt) != ss) {
                return false;
            }

            mapST.put(ss, tt);
            mapTS.put(tt, ss);
        }

        return true;
    }
}
