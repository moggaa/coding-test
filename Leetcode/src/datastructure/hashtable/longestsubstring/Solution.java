package datastructure.hashtable.longestsubstring;

import java.util.HashMap;
import java.util.Map;
/*
    3번문제 .
    1. 나이브하게는 O(n^2)으로 돌아간다.
    2. 슬라이딩 윈도우를 쓰면 O(2n) 까지 단축할 수 있다.
    3. HashTable 자료구조를 쓰면 O(n) 까지 최적화 가능
    나는 해쉬테이블을 썼지만 2번 효율성까지밖에 도달 못했다.
 */


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int windowStartIndex = 0;
        int maxLength = 0;
        Map<Character,Integer> charTable = new HashMap<>();
        for(int i=0; i<s.length();i++){
            char curChar = s.charAt(i);
            if(charTable.containsKey(curChar)){
                int beforeStartIndex = windowStartIndex;
                windowStartIndex = charTable.get(curChar)+1;
                for (int j = beforeStartIndex ; j < windowStartIndex ; j++){
                    charTable.remove(s.charAt(j));
                }

            }
            charTable.put(curChar,i);
            if(i-windowStartIndex+1> maxLength){
                maxLength = i - windowStartIndex + 1;
            }

        }
        return maxLength;
    }
}