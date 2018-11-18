package com.mgscoot.medium._208;

import com.mgscoot.medium._208.Trie;
public class Solution {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.printf("Search: apple, result:%b\n",trie.search("apple"));   // returns true
        System.out.printf("Search: app, result:%b\n",trie.search("app"));     // returns false
        System.out.printf("Startwith: app, result:%b\n",trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.printf("Search: app, result:%b\n",trie.search("app"));     // returns true


    }

}
