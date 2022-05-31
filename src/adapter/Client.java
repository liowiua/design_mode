package adapter;

interface Cat{
    void mewing();
    void catchMouse();
}

interface Dog{
    void barking();
    void action();
}

class ConcreteCat implements Cat{
    @Override
    public void mewing() {
        System.out.println("喵喵");
    }
    @Override
    public void catchMouse() {
        System.out.println( "开抓老鼠");
    }
}
class ConcreteDog implements Dog{
    @Override
    public void barking(){
        System.out.println("狗叫");
    }
    public void action(){ System.out.println( "没学会要干啥");}
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
    public void mewing()
    {
        System.out.print( "这是猫--");
        dog.barking();
    }
    @Override
    public void catchMouse() {
        cat.catchMouse();
    }
    @Override
    public void barking() {
        dog.barking();
    }
    @Override
    public void action()
    {
        System.out.print( "这是狗--");
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
        cat.mewing();
        dog = (Dog) adapter;
        dog.action();
    }
}
