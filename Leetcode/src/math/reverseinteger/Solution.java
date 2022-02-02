package math.reverseinteger;
/*
    수학 문제.
    숫자 뒤집는 것은 어렵지 않으나 추가적으로 overflow 하는 상황을 체크해야한다.
    나는 숫자를 다시 검증하는 방식으로 했으나, 공식 답안은 연산 마지막 전에 숫사가 범위를 넘어서는지만 체크했음.
 */
class Solution {
    public int reverse(int x) {
        int tempX = x;
        if (tempX == 0){
            return 0;
        }
        int answer = 0;
        int xLength = 0;
        while (tempX != 0){
            xLength ++;
            answer *= 10;
            answer += tempX % 10;
            tempX /= 10;
        }
        if (xLength == 10 && checkOutRange(x , answer)){
            return 0;
        }
        return answer;
    }
    public boolean checkOutRange(int x , int answer){
        int divNum = 1000000000;
        while(x != 0){
            if (answer/divNum != x%10){
                return true;
            }
            answer %= divNum;
            divNum /= 10;
            x /= 10;
        }
        return false;
    }
}