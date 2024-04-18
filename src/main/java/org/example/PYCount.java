package org.example;

public class PYCount {
    public static void main(String[] args) {
        String s = "Pyy";
        
        String upper = s.toUpperCase();
        int pCnt = upper.length() - upper.replaceAll("P", "").length();
        int yCnt = upper.length() - upper.replaceAll("Y", "").length();

        System.out.println(pCnt == yCnt);
    }
}
