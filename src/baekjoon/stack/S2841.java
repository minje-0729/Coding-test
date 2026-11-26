package baekjoon.stack;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Stack<Integer>> requiredMelody=new HashMap<>();//줄이 6개라 그냥 배열로 만드는게 더 간편
        int count=0;//손가락 움직인 횟수
        String[] melodyNum=br.readLine().split(" ");
        for(int i=0;i<Integer.parseInt(melodyNum[0]);i++){
            String[] melodyAndPlat=br.readLine().split(" ");
            int melody=Integer.parseInt(melodyAndPlat[0]);
            int plat=Integer.parseInt(melodyAndPlat[1]);

            if(!requiredMelody.containsKey(melody)){
                Stack<Integer> platStack=new Stack<Integer>();
                platStack.push(plat);
                requiredMelody.put(melody,platStack);
                count++;
            }

            else{//stack에 있는 프렛 처리해주기
                Stack<Integer> platStack=requiredMelody.get(melody);
                while(!platStack.isEmpty()&&platStack.peek()>plat){
                    platStack.pop();
                    count++;
                }

               if(!platStack.isEmpty()){
                    if(platStack.peek()!=plat){//동일하면 넣지 말기&다르면 넣기 //////<-동일한 경우에는 아무것도 안하면 되니까 무시해도 됨
                        count++;
                        platStack.push(plat);//이거랑
                    }
                }

                else{//비어 있으면 넣기
                    count++;
                    platStack.push(plat);//이거 같은 코드니까 조건을 합쳐서 만들기
                }

                /*if(platStack.isEmpty()||platStack.peek()<plat){
                    platStack.push(plat);
                    count++;
                }*/ //수정한 코드

            }
        }

        System.out.println(count);
    }
}
