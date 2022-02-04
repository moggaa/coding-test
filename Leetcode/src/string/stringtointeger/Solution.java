package string.stringtointeger;

/*
    문자열 처리 문제지만 정수 범위넘어가는것도 체크해야한다.
    조건들이 여러개로 되어있어 문제를 잘 읽고 까다롭게 테스트해봐야한다.
 */

class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        int index = 0;
        int intValue = 0;
        int minus = 1;
        if(s.length()==0){
            return 0;
        }
        if(s.charAt(index)=='-'){
            minus = -1;
            index++;
        }
        else if(s.charAt(index)=='+'){
            index++;
        }
        for (int i = index ; i < s.length() ; i++){
            if(s.charAt(index)<'0' || s.charAt(index)>'9'){
                return intValue;
            }
            int addNum = (s.charAt(index) - '0')*minus;
            if (intValue > Integer.MAX_VALUE/10 || (intValue == Integer.MAX_VALUE / 10 && addNum > 7)) return Integer.MAX_VALUE;
            if (intValue < Integer.MIN_VALUE/10 || (intValue == Integer.MIN_VALUE / 10 && addNum < -8)) return Integer.MIN_VALUE;
            intValue*= 10;
            intValue+= addNum;
            index++;
        }
        return intValue;
    }
}