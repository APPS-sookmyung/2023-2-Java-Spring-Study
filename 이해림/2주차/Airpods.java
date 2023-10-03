public class Airpods {

    public String product = "애플";
    public int version = 1;
    public String pro = "프로";

    public void show() {
        System.out.print(product + "에서 만든");
        System.out.print(" " + version + "세대");
        System.out.print(" " + pro + " 에어팟");
    }

    public static void main(String[] args) {
        Airpods myAirpods = new Airpods();
        myAirpods.show();
    }
}
