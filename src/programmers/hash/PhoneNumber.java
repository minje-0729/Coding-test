package programmers.hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class PhoneNumber {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> frontNum=new HashSet<>();
        frontNum.addAll(Arrays.asList(phone_book));

        for(String s:phone_book){//O(N)

            for(int i=1;i<s.length();i++){//Max20번 순환->상수 C;N의 최대는 100만이므로 O(N)으로 풀어야 함
                if(frontNum.contains(s.substring(0,i)))
                    return false;
            }
        }
        return answer;
    }
}
