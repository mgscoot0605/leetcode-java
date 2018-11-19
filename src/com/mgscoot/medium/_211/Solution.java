package com.mgscoot.medium._211;

import com.mgscoot.medium._211.WordDictionary;

public class Solution {

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");

        System.out.printf("search(\"pad\"): %b\n", obj.search("pad")); //false
        System.out.printf("search(\"bad\"): %b\n", obj.search("bad")); //true
        System.out.printf("search(\".ad\"): %b\n", obj.search(".ad")); //true
        System.out.printf("search(\"b..\"): %b\n", obj.search("b..")); //true


    }
}
