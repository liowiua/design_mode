package composite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

abstract class Component {

    public abstract void receiveDoc();
    public abstract String getName();
    public void setName(String name) {}
}

class Leaf extends Component{

    private String name;

    public void receiveDoc() {
        System.out.println(name + " 收到文件");
    }

    public void receiveDoc(String senior) {
        System.out.println(name + " 收到文件");
    }

    public Leaf(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Composite extends Component{

    private ArrayList<Component> list;
    private String name;

    public Composite(String name) {
        this.name = name;
        list = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void receiveDoc() {
        System.out.println(name + " 收到文件");
    }

    public List<Composite> getComposite(){
        ArrayList<Composite> temp = new ArrayList<>();
        for(Component c : this.list){
            if (c.getClass().getSimpleName().compareTo("Composite") == 0)
                temp.add((Composite) c);
        }
        return temp;
    }

    public List<Leaf> getLeaf(){
        ArrayList<Leaf> temp = new ArrayList<>();
        for(Component c : this.list){
            if (c.getClass().getSimpleName().compareTo("Leaf") == 0)
                temp.add((Leaf) c);
        }
        return temp;
    }

    public void add(Component branch) {
        this.list.add(branch);
    }
    public void remove(Component branch) {
        this.list.remove(branch);
    }

    public void sendDoc(Composite composite) {
        System.out.println(name+ " 发送文件到 " + composite.getName());
//        composite.receiveDoc();
    }
    public void sendDoc(Leaf leaf) {
        System.out.println(name+ " 发送文件到 " + leaf.getName());
        System.out.print(name);
        leaf.receiveDoc();
    }
}

public class Client {
    public static void main(String[] args) {
        Leaf edu = new Leaf("教务办公室");
        Leaf office = new Leaf("行政办公室");
        Composite beijing = new Composite("北京总部");
        Composite hunan = new Composite("湖南分校");
        beijing.add(edu);
        beijing.add(office);
        beijing.add(hunan);
        Composite changsha = new Composite("长沙教学点");
        Composite xiangtan = new Composite("湘潭教学点");
        hunan.add(changsha);
        hunan.add(xiangtan);
        hunan.add(edu);
        hunan.add(office);
        changsha.add(edu);
        changsha.add(office);
        xiangtan.add(edu);
        xiangtan.add(office);

        Queue<Composite> queue = new LinkedList<>();
        Composite temp = beijing;
        queue.add(temp);
        while ((temp = queue.poll())  != null) {
            temp.receiveDoc();
            for (Leaf l : temp.getLeaf())
                temp.sendDoc(l);
            for (Composite c : temp.getComposite()) {
                queue.add(c);
                temp.sendDoc(c);
            }
        }

    }
}
