package org.example;

public class CreateStrangeCharacters {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String[] arr = s.split("");
        int strCnt = 0;
        for (String str : arr) {
            if (str.equals(" ")) {
                sb.append(" ");
                strCnt = 0;
            } else {
                if (strCnt % 2 == 0) {
                    sb.append(str.toUpperCase());
                } else {
                    sb.append(str.toLowerCase());
                }
                strCnt++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

//        String s = "try hello world";
        String s = "  TRy HElLo  WORLD ";

        CreateStrangeCharacters app = new CreateStrangeCharacters();
        System.out.println(app.solution(s));
    }
}
