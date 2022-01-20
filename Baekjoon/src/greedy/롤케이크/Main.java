package greedy.롤케이크;

import java.lang.*;
import java.util.*;
/*
    백준 롤케이크 문제 (16206) Silver 1
    정렬 후 무난하게 10의 배수꼴인거 부터 처리하면 된다. (10이 되는거 먼저 처리)
    그리디 알고리즘 !!
 */

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static int rollCakeCount(int[] data, int n , int m)
    {
        int count = 0;
        Arrays.sort(data);
        List<Integer> tenMulList = new ArrayList<>();
        List<Integer> notTenMulList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (data[i]%10==0){
                if (data[i] ==10){
                    count++;
                }
                else{
                    tenMulList.add(data[i]);
                }
            }
            else if (data[i]>10){
                notTenMulList.add(data[i]);
            }
        }
        for (Integer cakeLength : tenMulList) {
            if(m == 0){
                return count;
            }

            if(m < cakeLength/10 -1){
                count += m;
                m = 0;
            }
            else{
                count += cakeLength/10;
                m -= cakeLength/10 - 1;
            }
        }
        for (Integer cakeLength : notTenMulList) {
            if(m == 0){
                return count;
            }
            if(m < cakeLength/10){
                count += m;
                m = 0;
            }
            else{
                count += cakeLength/10;
                m -= cakeLength/10;
            }
        }

        return count ;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int[] data = new int[n];

        int m = scanner.nextInt();

        for(int i = 0 ; i < n ; i++)
        {
            data[i] = scanner.nextInt();
        }

        System.out.println(rollCakeCount(data , n , m));
    }

}
