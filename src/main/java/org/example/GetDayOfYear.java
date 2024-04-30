package org.example;

import java.time.LocalDateTime;
import java.util.Scanner;

public class GetDayOfYear {

    public String solution(int a, int b) {

        LocalDateTime date = LocalDateTime.of(2016, a, b, 0, 0);
        return date.getDayOfWeek().toString().substring(0, 3);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("a : ");
        int a = sc.nextInt();
        System.out.print("b : ");
        int b = sc.nextInt();

        GetDayOfYear app = new GetDayOfYear();
        System.out.println(app.solution(a, b));
    }
}
