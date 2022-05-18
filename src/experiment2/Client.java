package experiment2;

interface Cat{
    void cry();
    void catchMouse();
}

interface Dog{
    void wang();
    void action();
}

class ConcreteCat implements Cat{
    @Override
    public void cry() {
        System.out.println("猫叫");
    }
    @Override
    public void catchMouse() {
        System.out.println( "猫抓老鼠");
    }
}
class ConcreteDog implements Dog{
    @Override
    public void wang(){
        System.out.println("狗叫");
    }
    public void action(){

    }
}

class Adapter implements Dog,Cat{
    private Cat cat;
    private Dog dog;
    public Cat getCat() {
        return cat;
    }
    public void setCat(Cat cat) {
        this.cat = cat;
    }
    public Dog getDog() {
        return dog;
    }
    public void setDog(Dog dog) {
        this.dog = dog;
    }
    @Override
    public void cry() //猫学狗叫
    {
        System.out.print( "猫学");
        dog.wang();
    }
    @Override
    public void catchMouse() {
        cat.catchMouse();
    }
    @Override
    public void wang() {
        dog.wang();
    }
    @Override
    public void action() //狗学猫抓老鼠
    {
        System.out.print( "狗学");
        cat.catchMouse();
    }
}

public class Client {
    public static void main(String args[])
    {
        Cat cat = new ConcreteCat();
        Dog dog = new ConcreteDog();
        Adapter adapter = new Adapter();
        adapter.setCat(cat);
        adapter.setDog(dog);
        cat = (Cat) adapter;
        cat.catchMouse();
        cat.cry();
        dog = (Dog) adapter;
        dog.action();
    }
}
