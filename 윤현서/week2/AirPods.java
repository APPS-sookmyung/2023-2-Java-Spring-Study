public class AirPods {
    public String product="애플";
    public int version=1;
    public String isPro="프로";
    public void show(){
        System.out.println(product+"에서 만든 "+version+"세대 "+isPro+" 에어팟");
    }
    public static void main(String[] args){
        AirPods myAirPods = new AirPods();
        myAirPods.show();
    }
}
