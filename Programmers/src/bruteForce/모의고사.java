package bruteForce;
import java.util.*;
// 무난한 완전탐색 문제 (Level 1)
// 반환타입이 배열이라 리스트로 담아서 다시 배열로 반환하는 작업이 까다로웠음
// 다차원 배열이 사이즈게 다르게 할당이 가능하다.


class Solution {
    public int[] solution(int[] answers) {
        int[][] prefix = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}};
        int [] prefixLength = {5,8,10};

        int [] score = new int[3];

        for (int i=0; i < answers.length ; i++){
            for (int j = 0 ; j < 3 ; j++){
                if (answers[i] == prefix[j][i%prefixLength[j]]){
                    score[j]++;
                }
            }
        }
        for (int i=0 ; i < 3 ; i++){
            System.out.println(score[i]);
        }
        int maxScore = 0;
        for (int i=0 ; i < 3 ; i++){
            if (maxScore < score[i]){
                maxScore = score[i];
            }
        }
        List<Integer> answerList = new ArrayList();
        for (int i=0 ; i < 3 ; i++){
            if (maxScore == score[i]){
                answerList.add(i+1);
            }
        }
        int[] answer = new int [answerList.size()];
        for (int i = 0 ; i < answer.length ; i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
