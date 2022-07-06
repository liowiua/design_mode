package factory;

interface Color {
    void draw();
}

class Red implements Color {

    @Override
    public void draw() {
        System.out.println("Inside Red::draw() method.");
    }
}

class Blue implements Color {

    @Override
    public void draw() {
        System.out.println("Inside Blue::draw() method.");
    }
}

class Yellow implements Color {

    @Override
    public void draw() {
        System.out.println("Inside Yellow::draw() method.");
    }
}

interface Creator {

    public Color createColor();
}


class RedCreator implements Creator{

    @Override
    public Red createColor(){
        return new Red();
    }
}
class BlueCreator implements Creator{

    @Override
    public Blue createColor(){
        return new Blue();
    }
}
class YellowCreator implements Creator{

    @Override
    public Yellow createColor(){
        return new Yellow();
    }
}

public class MethodClient {

    public static void main(String[] args) {
        RedCreator redCreator = new RedCreator();
        Red red = redCreator.createColor();
        red.draw();
    }
}