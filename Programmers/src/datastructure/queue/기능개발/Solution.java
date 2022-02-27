package datastructure.queue.기능개발;

import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> depQueue = new LinkedList<>();
        int curDay;
        int depCount;

        for(int i = 0 ; i < progresses.length ; i++){
            int day = (100 - progresses[i])/speeds[i];
            if((100 - progresses[i])%speeds[i]>0){
                day++;
            }
            depQueue.add(day);
        }
        while(!depQueue.isEmpty()){
            curDay = depQueue.poll();
            depCount = 1;
            while(!depQueue.isEmpty() && curDay >= depQueue.peek()){
                depCount++;
                depQueue.poll();
            }
            answerList.add(depCount);
        }
        return intListToArray(answerList);
    }
    public int[] intListToArray(List<Integer> intList){
        int[] intArray = new int[intList.size()];
        for (int i = 0 ; i < intList.size() ; i++){
            intArray[i] = intList.get(i);
        }
        return intArray;
    }
}