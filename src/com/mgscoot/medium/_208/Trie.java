package com.mgscoot.medium._208;

/**
 *  208. Implement Trie (Prefix Tree)
 *
 *  Implement a trie with insert, search, and startsWith methods.
 *
 *  Example:
 *
 *  Trie trie = new Trie();
 *
 *  trie.insert("apple");
 *  trie.search("apple");   // returns true
 *  trie.search("app");     // returns false
 *  trie.startsWith("app"); // returns true
 *  trie.insert("app");
 *  trie.search("app");     // returns true
 *  Note:
 *
 *  You may assume that all inputs are consist of lowercase letters a-z.
 *  All inputs are guaranteed to be non-empty strings.
 *
 *  Your Trie object will be instantiated and called as such:
 *  Trie obj = new Trie();
 *  obj.insert(word);
 *  boolean param_2 = obj.search(word);
 *  boolean param_3 = obj.startsWith(prefix);
 *
 */

import java.util.HashMap;
import java.lang.Character;

public class Trie {

    class Node {
        boolean isWord;
        HashMap<Character, Node> next;

        Node() {
            isWord = false;
            next  = new HashMap<Character, Node>();
        }
    }

    Node rootNode;

    /** Initialize your data structure here. */
    public Trie() {
        rootNode = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word==null || word.length()<1) {
            return;
        }
        char[] chars = word.toCharArray();
        Node currentNode = rootNode;
        for(int i=0; i<chars.length; i++) {
            if(!currentNode.next.containsKey(chars[i])) {
                currentNode.next.put(chars[i], new Node());
            }
            currentNode = currentNode.next.get(chars[i]);
            if(i==chars.length-1) {
                currentNode.isWord = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word==null || word.length()<1) {
            return false;
        }
        boolean isExist = false;
        char[] chars = word.toCharArray();
        Node currentNode = rootNode;
        for(int i=0; i<chars.length; i++) {
            if(!currentNode.next.containsKey(chars[i])) {
                break;
            }
            currentNode = currentNode.next.get(chars[i]);
            if(i==chars.length-1 && currentNode.isWord) {
                isExist = true;
                break;
            }
        }

        return isExist;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix==null || prefix.length()<1) {
            return false;
        }
        boolean isExist = false;
        char[] chars = prefix.toCharArray();
        Node currentNode = rootNode;
        for(int i=0; i<chars.length; i++) {
            if(!currentNode.next.containsKey(chars[i])) {
                break;
            }
            currentNode = currentNode.next.get(chars[i]);
            if(i==chars.length-1) {
                isExist = true;
                break;
            }
        }

        return isExist;
    }

}
