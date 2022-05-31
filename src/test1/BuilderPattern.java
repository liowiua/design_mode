package test1;

abstract class Builder {
    //创建产品对象
    protected Computer computer = new Computer();
    public abstract void buildCpu();

    public abstract void buildMemory();

    public abstract void buildDisk();

    public abstract void buildHost();

    public abstract void buildMonitor();

    public Computer getResult() {
        return computer;
    }
}

class Computer {
    private String cpu;
    private String memory;
    private String disk;
    private String host;
    private String monitor;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }


    public void show() {
        System.out.println("Computer{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk='" + disk + '\'' +
                ", host='" + host + '\'' +
                ", monitor='" + monitor + '\'' +
                '}');
    }


}

class ComputerBuilder extends Builder {

    @Override
    public void buildCpu() {
        computer.setCpu("core");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("Toshiba");
    }

    @Override
    public void buildDisk() {
        computer.setDisk("Samsung");
    }

    @Override
    public void buildHost() {
        computer.setHost("other");
    }

    @Override
    public void buildMonitor() {
        computer.setMonitor("Samsung");
    }
}

class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }
    //产品构建与组装方法
    public Computer construct() {
        builder.buildCpu();
        builder.buildMemory();
        builder.buildDisk();
        builder.buildHost();
        builder.buildMonitor();

        return builder.getResult();
    }
}

public class BuilderPattern{
    public static void main(String[] args) {
        Builder builder = new ComputerBuilder();
        Director director = new Director(builder);
        Computer computer = director.construct();
        computer.show();
    }
}

