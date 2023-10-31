import java.util.Scanner;

public class array {
    public static void main(String[] args) {
        int[][] numbers = new int[3][3];
        Scanner scan = new Scanner(System.in);
        System.out.println("1~10 사이의 정수를 9개 입력하시오 (빈 칸으로 구분)>> ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                numbers[i][j] = scan.nextInt();
                if (numbers[i][j] < 1 || numbers[i][j] > 10) {
                    System.out.println("1에서 10 사이의 정수가 아닙니다.");
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += numbers[i][j];
            }
            double average = (double) sum / 3;
            System.out.println((i + 1) + "번째 행의 평균: " + average);
        }

    }
}