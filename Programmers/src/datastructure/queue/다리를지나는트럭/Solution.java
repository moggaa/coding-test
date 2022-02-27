package datastructure.queue.다리를지나는트럭;

import java.util.*;
import java.lang.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> waitQueue = new LinkedList<>();
        Queue<Integer> passingQueue = new LinkedList<>();
        Queue<Integer> passTimeQueue = new LinkedList<>();
        int passingWeightSum = 0;
        int curTime = 0;
        for (int truck_weight : truck_weights) {
            waitQueue.add(truck_weight);
        }
        while(!waitQueue.isEmpty() || !passingQueue.isEmpty()){
            curTime++;
            if(!passingQueue.isEmpty() && (curTime - passTimeQueue.peek() >= bridge_length)){
                passTimeQueue.poll();
                passingWeightSum -= passingQueue.poll();
                System.out.println(curTime);
            }
            if(!waitQueue.isEmpty() && passingWeightSum + waitQueue.peek() <= weight){
                passingWeightSum += waitQueue.peek();
                passingQueue.add(waitQueue.poll());
                passTimeQueue.add(curTime);
            }

        }
        return curTime;
    }
}