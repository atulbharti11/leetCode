/*
Remove repeated characters that appear more than twice in a string

11122233 -> 112233
1234445566666 -> 123445566

*/

class Solution {
    public String solution(String S) {
        // write your code in Java SE 8
        int count = 1;

        StringBuilder stb = new StringBuilder();
        stb.append(S.charAt(0));

        for(int i=1;i<S.length();i++) {
            char c = S.charAt(i);
            if(c == S.charAt(i-1))
                count++;
            else {
                count = 1;
            }
            if(count < 3)
                stb.append(c);
        }
        return stb.toString();
    }
}
