package Math.제곱노;

import java.lang.*;
import java.util.*;
import java.io.*;


public class Main {
    /*
        백준 제곱노 문제 (Gold 1)
        소수들만  나눠보는것..으로 할 수 있으나 -> 그냥 에라토스테네스의 체 의 개념을 빌린 for문으로 돌려도 문제 해결 가능하다..
        또한 성능 개선을 위해 배열의 기본 값 초기화와 한 for문 안에 count로직을 넣었다.(근데 굳이 이럴필요 없는듯)
        아무튼 수학 ? 관련 문제 (큰 수 주의할것)
     */


    public static long countNotSquaredNumber(Long min , Long max){
        int count = 0;
        boolean [] isPrime = calPrime();
        boolean[] data = new boolean[(int) (max - min + 1)];
        for (long i = 0 ; i < 1000002 ; i++){
            if (!isPrime[(int)i]){
                for (long j = (min /(i *i))*(i*i); j<= max ; j+=i*i){
                    if(j >= min && !data[(int)(j-min)]){
                        data[(int)(j-min)] = true;
                        count++;
                    }

                }
            }
        }
        return max - min + 1 - count;

    }
    public static boolean[] calPrime(){
        boolean[] isPrime = new boolean[1000002];
        isPrime[0] = true;
        isPrime[1] = true;
        for (int i = 2 ; i*i < 1000002; i++){
            if (!isPrime[i]){
                for (int j = i*2 ; j < 1000002 ; j+=i){
                    isPrime[j] = true;
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long min = Long.parseLong(st.nextToken());
        Long max = Long.parseLong(st.nextToken());
        System.out.println(countNotSquaredNumber(min,max));

    }

}
/*
처음 제출 코드

import java.lang.*;
import java.util.*;
import java.io.*;


public class Main {


    public static int countNotSquaredNumber(Long min , Long max){
        int count = 0;
        boolean [] isPrime = calPrime();
        boolean[] data = new boolean[(int) (max - min + 1)];
        for (int i = 0 ; i< (int) (max - min + 1); i++ ){
            data[i] = true;
        }
        for (long i = 0 ; i < 1000002 ; i++){
            if (isPrime[(int)i]){
                for (long j = (min /(i *i))*(i*i); j<= max ; j+=i*i){
                    if(j >= min){
                        data[(int)(j-min)] = false;
                    }

                }
            }
        }
        for (int i = 0 ; i< (int) (max - min + 1); i++ ){
           if (data[i]){
               count++;
           }
        }
        return count;

    }
    public static boolean[] calPrime(){
        boolean[] isPrime = new boolean[1000002];
        for (int i = 0 ; i < 1000002 ; i++){
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2 ; i < Math.sqrt(1000002); i++){
            if (isPrime[i]){
                for (int j = i*2 ; j < 1000002 ; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long min = Long.parseLong(st.nextToken());
        Long max = Long.parseLong(st.nextToken());
        System.out.println(countNotSquaredNumber(min,max));

    }

}
 */