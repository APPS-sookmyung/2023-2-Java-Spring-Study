import java.util.Scanner;
public class scanex {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n[][] = new int[3][3];
        System.out.print("1~10 사이의 정수를 9개 입력하시오. (빈 칸으로 구분) >> ");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int m= scan.nextInt();
                n[i][j]=m;
            }
        }
        for(int i=0;i<3;i++){
           int sum=0;
           for(int j=0;j<3;j++){
               sum+=n[i][j];
           }
            float ave=(float) sum/3;
            System.out.println((i+1)+"번째 행의 평균 : "+ave);
        }
    }
}
