package baekjoon.hash;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class H10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> intersection=new HashSet<>(); //변수 이름 잘쓰기

        String[] set1set2Num=br.readLine().split(" ");
        int set1set2NumSum=Integer.parseInt(set1set2Num[0])+Integer.parseInt(set1set2Num[1]);

        String[] set1=br.readLine().split(" ");

        for(String s:set1){
            intersection.add(Integer.parseInt(s));
        }

        String[] set2=br.readLine().split(" ");

        for(String s:set2){
            intersection.add(Integer.parseInt(s));
        }

        int intersectionNum=intersection.size();
        System.out.println((intersectionNum*2)-set1set2NumSum);

    }
}
