package hello.core.singleton;

public class SingletionService {

    private  static  final  SingletionService instance = new SingletionService();

    public static  SingletionService getInstance(){
        return instance;
    }

    private SingletionService(){

    }

    private void logic(){
        System.out.println(" 싱글톤 객체 로직 호출");
    }
}
