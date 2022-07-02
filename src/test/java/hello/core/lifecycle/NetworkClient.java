package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("Connet=" + url);
    }

    public void call(String message) {
        System.out.println("Call=" + url + "mesaaage=" + message);
    }
    //서비스종료시 호출

    public void disconnect() {
        System.out.println("close" + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() {
        System.out.println("close");
        disconnect();
    }
}
