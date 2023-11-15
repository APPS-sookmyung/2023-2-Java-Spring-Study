public class week6 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread thread = new Thread(mt);
        thread.start();
    }

}

class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.print("*");
        }
    }
}