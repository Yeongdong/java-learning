package network.tcp.autocloseable;

/**
 * call() : 정상 로직 호출
 * callEx() : 비정상 로직 호출 CallException을 던진다.
 * close() : 정상 종료
 * closeEx() : 비정상 종료, CloseException을 던진다.
 */
public class ResourceV1 {
    private String name;

    public ResourceV1(String name) {
        this.name = name;
    }

    public void call() {
        System.out.println(name + " call");
    }

    public void callEx() throws CallException {
        System.out.println(name + " callEx");
        throw new CallException(name + " ex");
    }

    public void close() {
        System.out.println(name + " close");
    }

    public void closeEx() throws CloseException {
        System.out.println(name + " closeEx");
        throw new CloseException(name + " ex");
    }
}
