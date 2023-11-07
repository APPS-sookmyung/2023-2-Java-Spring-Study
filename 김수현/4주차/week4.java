import java.util.Scanner;

public class week3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("1~10 사이의 정수를 9개 입력하시오 (빈 칸으로 구분) >> ");
		int score[][] = new int[3][3];
			for(int i = 0; i < score.length; i++) {
				for (int j = 0; j < score[0].length; j++) {
					score[i][j] = scan.nextInt();
				}
			}
		for (int i = 0; i < score.length; i++) {
			int sum = 0;
			for (int j = 0; j < score[0].length; j++) {
				sum += score[i][j];
			}
			double average = (double) sum / score[0].length;
			System.out.println(i+1 +"번째 행의 평균 : " + average);
		}
		
		
		scan.close();
	}

}
