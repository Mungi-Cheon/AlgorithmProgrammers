import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TargetNumber {

    private int answer = 0;

    public int solution1(int[] numbers, int target) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> sumList;
        stack.push(numbers[0]);
        stack.push(-numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            sumList = new ArrayList<>();

            while (!stack.isEmpty()) {
                int curSum = stack.pop();

                sumList.add(curSum + numbers[i]);
                sumList.add(curSum - numbers[i]);
            }

            for (int sum : sumList) {
                stack.push(sum);
            }
        }

        while (!stack.isEmpty()) {
            if (target == stack.pop()) {
                answer++;
            }
        }
        return answer;
    }

    public int solution2(int[] numbers, int target) {
        answer = 0;
        recursive(numbers, 0, target, 0);
        return answer;
    }

    private void recursive(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
        } else {
            recursive(numbers, depth + 1, target, sum + numbers[depth]);
            recursive(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }

    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

//        int[] numbers = {4, 1, 2, 1};
//        int target = 4;
        TargetNumber app = new TargetNumber();
        System.out.println(app.solution1(numbers, target));
        System.out.println(app.solution2(numbers, target));
    }
}