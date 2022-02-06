package math.palindromenumber;
import java.util.ArrayList;


/*
    수학 관련 문제.
    ArrayList 안쓰고 더 깔끔하게 푸는 방법이 있었다.
 */

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        ArrayList<Integer> numList = new ArrayList();
        while (x > 0){
            numList.add(x%10);
            x /= 10;
        }
        for (int i=0 ; i < numList.size()/2 ; i++){
            if (numList.get(i) != numList.get(numList.size()-1-i)){
                return false;
            }
        }
        return true;
    }
}