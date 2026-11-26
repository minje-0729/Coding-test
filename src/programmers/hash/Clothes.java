package programmers.hash;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Clothes {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;
            HashMap<String,Integer> clothesMap=new HashMap<>();
            for(int i=0;i<clothes.length;i++){
                if(!clothesMap.containsKey(clothes[i][1]))
                    clothesMap.put(clothes[i][1],1);
                else{
                    int count=clothesMap.get(clothes[i][1]);
                    clothesMap.put(clothes[i][1],count+1);
                }
            }

            int clothesType=clothesMap.size();
            int sum=1;
            Collection countValue=clothesMap.values();
            Iterator it= countValue.iterator();
            while(it.hasNext()){
                sum*=(Integer)it.next();
            }
            return sum-1;
        }
    }
}

/*
class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String,Integer> clothesMap=new HashMap<>();
            for(int i=0;i<clothes.length;i++){
                if(!clothesMap.containsKey(clothes[i][1]))
                    clothesMap.put(clothes[i][1],1);
                else{
                    int count=clothesMap.get(clothes[i][1]);
                    clothesMap.put(clothes[i][1],count+1);
                }
            }
            //////////////////////////////

            ->장황하게 긺 merge로 간단하게 만들기
            for(String[] c:clothes){
                clothesMap.merge(c[1],1,Integer::sum);//->key에 1을 넣되 이미 값이 있으면 1을 더해서(sum)넣어라;Integer::sum 람다식
            }

            int sum=1;
            Collection countValue=clothesMap.values();
            Iterator it= countValue.iterator();
            while(it.hasNext()){
                sum*=(Integer)it.next();
            }//raw 타입 쓰지 말기->캐스팅 위험

            /////////////////////////////

            for(int count:clothes.values())//values()는 Collection타입 리턴&Collection은 Iterable 상속하므로 for문에 사용가능
                answer+=(count+1);

            return sum-1;
        }
    }



 */
