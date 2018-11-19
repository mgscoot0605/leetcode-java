package com.mgscoot.medium._211;

/**
 *  211. Add and Search Word - Data structure design
 *
 *  Design a data structure that supports the following two operations:
 *
 *  void addWord(word)
 *  bool search(word)
 *  search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 *  Example:
 *
 *  addWord("bad")
 *  addWord("dad")
 *  addWord("mad")
 *  search("pad") -> false
 *  search("bad") -> true
 *  search(".ad") -> true
 *  search("b..") -> true
 *
 *  Note:
 *  You may assume that all words are consist of lowercase letters a-z.
 *
 *  Your WordDictionary object will be instantiated and called as such:
 *  WordDictionary obj = new WordDictionary();
 *  obj.addWord(word);
 *  boolean param_2 = obj.search(word);
 */

import java.util.HashMap;
import java.lang.Character;

public class WordDictionary {

    class TrieNode {
        boolean isWord;
        HashMap<Character, TrieNode> next;

        TrieNode() {
            isWord = false;
            next = new HashMap<Character, TrieNode>();
        }
    }

    TrieNode rootNode;

    /** Initialize your data structure here. */
    public WordDictionary() {
        rootNode = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word==null || word.length()<1) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode currentNode = rootNode;
        for(int i=0; i<chars.length; i++) {
            if(!currentNode.next.containsKey(chars[i])) {
                currentNode.next.put(chars[i], new TrieNode());
            }
            currentNode = currentNode.next.get(chars[i]);
            if(i==chars.length-1) {
                currentNode.isWord=true;
                break;
            }
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word==null || word.length()<1) {
            return false;
        }
        boolean isExist = false;
        char[] chars = word.toCharArray();
        TrieNode currentNode = rootNode;
        for(int i=0; i<chars.length; i++) {
            if(chars[i] == '.') {
                for(Character key: currentNode.next.keySet()) {
                    char[] charsTmp = chars;
                    charsTmp[i] = key;
                    if(search(new String(charsTmp))) {
                        isExist = true;
                        break;
                    }
                }
                break;
            } else if (chars[i] != '.' && !currentNode.next.containsKey(chars[i])) {
                break;
            }
            currentNode = currentNode.next.get(chars[i]);
            if(i==chars.length-1 && currentNode.isWord) {
                isExist = true;
            }
        }

        return isExist;
    }

}
