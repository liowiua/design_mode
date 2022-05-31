package test1;

import java.lang.String;
interface Person{
	void say();
}

class Man implements Person{
	@Override
	public void say(){
		System.out.println("I'm man");
	}
}

class WoMan implements Person{
	@Override
	public void say(){
		System.out.println("I'm woman");
	}
}

class Robot implements Person{
	@Override
	public void say(){
		System.out.println("I'm robot");
	}
}

class Nvwa {
	public static Person factory(String arg){
		if(arg.compareTo("M") == 0){
			return new Man();
		}else if(arg.compareTo("W") == 0){
			return new WoMan();
		}else if(arg.compareTo("R") == 0){
			return new Robot();
		}
		return null;
	}
}

public class SimpleFactory{
	public static void main(String[] args) {
		Man man = (Man) Nvwa.factory("M");
		WoMan woman = (WoMan) Nvwa.factory("W");
		Robot robot = (Robot) Nvwa.factory("R");

		man.say();
		woman.say();
		robot.say();
	}
}