package hello.core.beanfind.singleton;

public class StatefulService {
/*
    private int price; //상태를 유지하는 필드 (10000 -> 20000)

    public void order(String name, int price){
        System.out.println("name = " + name + "  price = " + price);
        this.price = price; // 여기가 문제!!
    }

    public int getPrice() {
        return price;
    }

    */


    // ==============문제해결===============(지역변수로 리팩토링)
    // private int price; //상태를 유지하는 필드 (10000 -> 20000)

    public int order(String name, int price){
        System.out.println("name = " + name + "  price = " + price);
        return price;
    }



}
