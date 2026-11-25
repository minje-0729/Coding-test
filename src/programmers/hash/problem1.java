package programmers.hash;
import java.util.*;
import java.io.*;

public class problem1 {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] participant=br.readLine().split(" ");
        String[] completion=br.readLine().split(" ");
        System.out.println(solution(participant,completion));
    }

    static String solution(String[] participant,String[] completion){
        HashMap<String,Integer> completePeopleList=new HashMap<>();
        for(String p:completion) {
            if (!completePeopleList.containsKey(p))
                completePeopleList.put(p,1);
            else{
                int count=completePeopleList.get(p);
                completePeopleList.put(p,++count);
            }
        }

        String res="";

        for(String p:participant){
            if(!completePeopleList.containsKey(p)||completePeopleList.get(p)==0){
                res=p;
                break;
            }
            int count=completePeopleList.get(p);
            completePeopleList.put(p,--count);
        }

        return res;
    }
}

