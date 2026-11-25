package programmers.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer,Integer> phoneketmonList=new HashMap<>();//인원 수 필요없으니까 HashSet사용하기

        for(int pNum:nums){
            Integer count=phoneketmonList.get(pNum);//1

            if(count==null){
                phoneketmonList.put(pNum,1);//2번 해시 참조->merge로 합쳐서 1번 참조로 효율 높이기
            }

            else {
                phoneketmonList.put(pNum, ++count);
            }
        }

        return Math.min(phoneketmonList.size(), nums.length / 2);
    }
}
