package org.example;

import java.util.LinkedList;
import java.util.List;

public class Process {

    public int solution(int[] priorities, int location) {
        LinkedList<Integer[]> queue = new LinkedList<>();
        List<Integer[]> printList = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Integer[]{i, priorities[i]});
        }

        while (!queue.isEmpty()) {
            Integer[] cur = queue.poll();
            boolean isPriority = true;
            for (Integer[] next : queue) {
                if (cur[1] < next[1]) {
                    // 우선 순위가 더 높은 프로세스가 있음
                    isPriority = false;
                    break;
                }
            }
            if (isPriority) {
                // 더 높은 프로세스가 없으므로 프린트 리스트에 넣기
                printList.add(cur);
            } else {
                // 더 높은 프로세스가 있는경우 queue에 다시 넣기
                queue.add(cur);
            }
        }
        int answer = -1;
        for (int i = 0; i < printList.size(); i++) {
            if (printList.get(i)[0] == location) {
                return i + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] priorities
            = {2, 1, 3, 2};
//            = {1, 1, 9, 1, 1, 1};

        int location
            = 2;
//            = 0;

        Process app = new Process();
        System.out.println(app.solution(priorities, location));
    }
}
