package com.mgscoot.medium._049;

/**
 *  49. Group Anagrams
 *  Given an array of strings, group anagrams together.
 *
 *  Example:
 *      Input:
 *      ["eat", "tea", "tan", "ate", "nat", "bat"]
 *
 *      Output:
 *      [
 *          ["ate","eat","tea"],
 *          ["nat","tan"],
 *          ["bat"]
 *      ]
 *
 *  Note:
 *  All inputs will be in lowercase.
 *  The order of your output does not matter.
 *
*/

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.String;


public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null) {
            return null;
        }

        HashMap<String, List<String>> map = new HashMap();
        for(int i=0; i<strs.length; i++) {
            String sortString = sortWords(strs[i]);
            List<String> element = new ArrayList<>();
            if(map.containsKey(sortString)) {
                element = map.get(sortString);
            }
            element.add(strs[i]);
            map.put(sortString, element);
        }

        for(String key: map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

    public static String sortWords(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sortString = new String(chars);

        return sortString;
    }

    public static void main(String[] args) {
        String source[] = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution s = new Solution();
        System.out.printf("result: %s\n", String.valueOf(s.groupAnagrams(source)));
    }
}
