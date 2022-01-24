package greedy.행렬;

import java.lang.*;
import java.util.*;
import java.io.*;

/*
    백준 행렬 문제 (silver 1)
    그리디 아이디어만 찾아내면 풀 수 있다. (3*3 이라는 조건과 중심 대각선 위에를 그리디하게 변환)
    그러나 문자 입력받느라 고생했다.
    앞으로 이 코드를 많이 참고해봐야겠다. (입력 관련)

 */

public class Main {
    public static int matrix(int n , int m , int [][] beforeData , int [][] afterData)
    {
        int count = 0;

        for (int i = 1; i + 1 < n ; i++){
            for (int j = 1; j + 1 < m ; j++){
                if (beforeData[i-1][j-1] != afterData[i-1][j-1]){
                    reverse(beforeData , i , j);
                    count ++;
                }
            }
        }
        for(int i = 0 ; i < n ;i++){
            for (int j = 0 ; j < m ; j++){

                if (beforeData[i][j] != afterData[i][j]){
                    return -1;
                }
            }
        }
        return count;
    }
    public static void reverse(int [][] data , int centerX , int centerY){

        for(int i = centerX - 1 ; i <= centerX +1 ; i ++){
            for (int j = centerY - 1 ; j <= centerY + 1  ; j++){
                data[i][j] = data[i][j]==0 ? 1:0;
            }
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] beforeData = new int [n][m];
        int[][] afterData = new int [n][m];
        String inputStr;
        for(int i = 0 ; i < n ;i++){
            for (int j = 0 ; j < m ; j++){
                beforeData[i][j] = Character.getNumericValue(br.read());
            }
            br.readLine();
        }

        for(int i = 0 ; i < n ;i++){
            for (int j = 0 ; j < m ; j++){
                afterData[i][j] = Character.getNumericValue(br.read());
            }
            br.readLine();
        }
        System.out.println(matrix(n , m , beforeData ,afterData));

    }

}