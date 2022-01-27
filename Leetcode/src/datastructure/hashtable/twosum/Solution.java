package datastructure.hashtable.twosum;

import java.util.Arrays;
/*
    리트코드 1번문제
    나이브하게 생각하면 n^2으로 풀리나 n 으로 풀려면 hashtable 알고리즘을 써야한다. (hashmap) (답지 참고)
    나는 nlogn으로 풀었다. (정렬 후 minindex ,maxindex 값으로 올리고 줄이면서)
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] copyNums = nums.clone();
        Arrays.sort(copyNums);
        int minIndex=0;
        int maxIndex=copyNums.length -1;
        int [] answerNum = new int[2];
        while(minIndex<=maxIndex){
            int sum = copyNums[minIndex] + copyNums[maxIndex];
            if(sum == target){
                answerNum[0] = copyNums[minIndex];
                answerNum[1] = copyNums[maxIndex];
                break;
            }
            else if (sum < target){
                minIndex++;
            }
            else{
                maxIndex--;
            }
        }
        int [] answerIndex = new int[2];
        answerIndex[0] = -1;
        answerIndex[1] = -1;
        for (int i=0; i < nums.length ; i++){
            if (nums[i] == answerNum[0] && answerIndex[0] ==-1){
                answerIndex[0] = i;
            }
            else if (nums[i] == answerNum[1] && answerIndex[1] == -1){
                answerIndex[1] = i;
            }
        }
        return answerIndex;
    }
}