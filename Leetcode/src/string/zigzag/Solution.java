package string.zigzag;

/*
    string 관련 문제. String을 동적으로 추가하기 위해서는 StringBuilder를 쓰자.
    문제는 별찍기와 비슷하게 패턴만 알면 풀 수 있는 문제.
*/

class Solution {
    public String convert(String s, int numRows) {
        int strLen = s.length();
        if (numRows == 1 || strLen <= numRows){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < strLen ; i += 2*(numRows-1)){
            sb.append(s.charAt(i));
        }
        for(int i = 1 ; i < numRows -1 ; i++){
            int j = i;
            while(j < strLen){
                sb.append(s.charAt(j));
                j += 2*(numRows - i - 1);
                if (j >= strLen){
                    break;
                }
                sb.append(s.charAt(j));
                j += 2*i;
            }
        }
        for (int i = numRows - 1 ; i < strLen ; i += 2*(numRows-1)){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}