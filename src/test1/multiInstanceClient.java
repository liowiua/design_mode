package test1;
import java.util.List;
import java.util.ArrayList;
enum InstanceStatus{FREE,BUSY}

class MultiInstance{
    private static List<MultiInstance> list = new ArrayList<>();
    static {
        for (int i=0; i< 5; i++) {
            MultiInstance obj = new MultiInstance("INSTANCE" + (i+1));
            list.add(obj);
        }
    }
    //当前实例状态
    private InstanceStatus status ;
    //当前实例名称
    private String name ;
    //私有化构造器
    private MultiInstance(String name ) {
        this.status = InstanceStatus.FREE;
        this.name = name;
    }
    public static MultiInstance getInstance() {
        for (MultiInstance obj : list) {
            if (obj.status == InstanceStatus.FREE) {
                obj.status = InstanceStatus.BUSY;
                return obj;
            }
        }
        return null;
    }
    public void giveBack() {
        this.status = InstanceStatus.FREE;
        System.out.println(name + ": I'm free now...");
    }
    public void doSomething() {
        System.out.println(name + ": I'm working...");
    }
}

public class multiInstanceClient {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                MultiInstance obj = MultiInstance.getInstance();
                if (obj != null) {
                    obj.doSomething();
                    obj.giveBack();
                } else {
                    System.out.println("Waiting for an instance...");
                }
            }).start();
        }
    }
}
