package com.mgscoot.hard._76;

/**
 *  76. Minimum Window Substring
 *  Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 *  Example:
 *      Input: S = "ADOBECODEBANC", T = "ABC"
 *                  i            j
 *      Output: "BANC"
 *      Note:
 *
 *  If there is no such window in S that covers all characters in T, return the empty string "".
 *  If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */

//Incompleted example

import java.util.HashMap;
import java.lang.String;
import java.lang.Character;

public class Solution {

    public String minWindow(String s, String t) {
        String result = "";

        if(s == null || t == null) {
            return result;
        }

        if(s.length() < t.length()) {
            return result;
        }

        HashMap<Character, int[]> tMap = new HashMap<>();
        char[] tArray = t.toCharArray();
        char[] sArray = s.toCharArray();

        for(char t_char : tArray) {
            int[] value = new int[]{0,1};
            if(tMap.containsKey(t_char)) {
                value[1] = tMap.get(t_char)[1] + 1;
            }
            tMap.put(t_char, value);
        }
        for(char s_char : sArray) {
            if(tMap.containsKey(s_char)) {
                int[] value = tMap.get(s_char);
                value[0] = value[0]+1;
                tMap.put(s_char, value);
            }
        }

        boolean isLeftLocked = false;
        boolean isRightLocked = false;
        int leftIndex = 0;
        int rightIndex = sArray.length;
        while(!isLeftLocked) {
            if(leftIndex >= rightIndex) {
                leftIndex--;
                break;
            }
            if(tMap.containsKey(sArray[leftIndex])) {
                if(tMap.get(sArray[leftIndex])[0] == tMap.get(sArray[leftIndex])[1]) {
                    isLeftLocked = true;
                    break;
                }
                int[] value = tMap.get(sArray[leftIndex]);
                value[0] = value[0]-1;
                tMap.put(sArray[leftIndex], value);
            }
            leftIndex++;
        }

        while(!isRightLocked) {
            if(leftIndex >= rightIndex) {
                break;
            }
            if(tMap.containsKey(sArray[rightIndex-1])) {
                if(tMap.get(sArray[rightIndex-1])[0] == tMap.get(sArray[rightIndex-1])[1]) {
                    isRightLocked = true;
                    break;
                }
                int[] value = tMap.get(sArray[rightIndex-1]);
                value[0] = value[0]-1;
                tMap.put(sArray[rightIndex-1], value);
            }
            rightIndex--;
        }

        if(isLeftLocked && isRightLocked) {
            result = s.substring(leftIndex, rightIndex);
        }

        return result;
    }

    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        Solution solution = new Solution();
        System.out.printf("%s\n", solution.minWindow(s, t));
    }
}