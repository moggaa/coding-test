package math.integertoroman;

import java.util.HashMap;

/*
    수학 관련 문제. 배열을 이용해서 문자들을 다 저장하는 문제 의도 외의 방법이 있어서 문제가 좋다곤 할 수 없다.
 */

class Solution {
    public String intToRoman(int num) {
        HashMap<Integer,String> romanMap = new HashMap<>();
        romanMap.put(1,"I");
        romanMap.put(4,"IV");
        romanMap.put(5,"V");
        romanMap.put(9,"IX");
        romanMap.put(10,"X");
        romanMap.put(40,"XL");
        romanMap.put(50,"L");
        romanMap.put(90,"XC");
        romanMap.put(100,"C");
        romanMap.put(400,"CD");
        romanMap.put(500,"D");
        romanMap.put(900,"CM");
        romanMap.put(1000,"M");
        int divideNum = 1000;
        StringBuilder sb = new StringBuilder();
        while(divideNum >= 1){
            int curNum = num/divideNum;
            if(curNum == 4 || curNum == 9){
                sb.append(romanMap.get(curNum * divideNum));
            }
            else{
                if (curNum >= 5){
                    sb.append(romanMap.get(5 * divideNum));
                    curNum -= 5;
                }
                for(int i = 0 ; i < curNum ; i++){
                    sb.append(romanMap.get(divideNum));
                }
            }
            num%=divideNum;
            divideNum/=10;
        }
        return sb.toString();
    }
}