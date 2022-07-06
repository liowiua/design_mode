package birdge;

abstract class Shape {
    Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();
}

class Circle extends Shape{

    public void draw() {
        color.bepaint("正方形");
    }
}

class Rectangle extends Shape{

    public void draw() {
        color.bepaint("长方形");
    }

}

class Square extends Shape{

    public void draw() {
        color.bepaint("正方形");
    }

}

interface Color {
    public void bepaint(String shape);
}

class White implements Color{

    public void bepaint(String shape) {
        System.out.println("白色的" + shape);
    }

}

class Gray implements Color{

    public void bepaint(String shape) {
        System.out.println("灰色的" + shape);
    }
}

class Black implements Color{

    public void bepaint(String shape) {
        System.out.println("黑色的" + shape);
    }
}

public class Client {
    public static void main(String[] args) {
        //白色
        Color white = new White();
        //正方形
        Shape square = new Square();
        //白色的正方形
        square.setColor(white);
        square.draw();

        //长方形
        Shape rectange = new Rectangle();
        rectange.setColor(white);
        rectange.draw();
    }
}