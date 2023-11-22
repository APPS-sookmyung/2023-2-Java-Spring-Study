public class week6 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread thread = new Thread(mt);
        mt.start();
    }

}

class MyThread extends Thread{
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.print("*");
        }
    }
}