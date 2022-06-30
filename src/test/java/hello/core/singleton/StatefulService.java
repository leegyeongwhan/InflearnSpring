package hello.core.singleton;

public class StatefulService {

//    private int price; ///상태를 유지하는 필드

    public int order(String name, int pirce) {
        System.out.println("name = " + name + "price=" + pirce);
       // this.price = pirce; //여기가 문제
        return pirce;
    }

//    public int getPrice() {
//        return price;
//    }
}
