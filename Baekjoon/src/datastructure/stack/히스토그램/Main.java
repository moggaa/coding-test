package datastructure.stack.히스토그램;

import java.io.*;
import java.lang.*;
import java.util.*;

/*
    백준 stack 관련 문제.
    기초적인 structure는 알고리즘 강의를 참고했고 핵심 메서드만 작성하였다.
    스택을 이용한다는 아이디어와 로직을 예외없이 구현한다는 점에서 어려웠다. (플레5문제)
 */


public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static long getLargestRectangleArea(int n, Histogram[] histograms) {
        long answer = 0;

        Stack<Histogram> continuedHistograms = new Stack<>();
        continuedHistograms.push(new Histogram(-1 , 0));
        for (int i = 0 ; i < n ; i++){
            while(histograms[i].height < continuedHistograms.peek().height){
                Histogram popHistogram = continuedHistograms.pop();
                long width = histograms[i].leftX - continuedHistograms.peek().rightX;
                long height = popHistogram.height;
                long popArea = width * height;
                if (answer < popArea){
                    answer = popArea;
                }
            }
            continuedHistograms.push(histograms[i]);
        }
        while(continuedHistograms.size()>1){
            Histogram popHistogram = continuedHistograms.pop();
            long width = (long)n - continuedHistograms.peek().rightX;
            long height = popHistogram.height;
            long popArea = width * height;
            if (answer < popArea){
                answer = popArea;
            }
        }

        return answer;
    }


    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();

        Histogram[] histograms = new Histogram[n];
        for(int i = 0 ; i < n ; i ++) {
            int height = scanner.nextInt();
            histograms[i] = new Histogram(i, height);
        }

        long answer = getLargestRectangleArea(n, histograms);
        System.out.println(answer);
    }

}

class Histogram{
    public final int height;
    public final int leftX;
    public final int rightX;

    public Histogram(int index, int height) {
        this.leftX = index;
        this.rightX = this.leftX + 1;
        this.height = height;
    }

}