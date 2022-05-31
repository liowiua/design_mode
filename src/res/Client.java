package res;

class Info{
    private int number;
    Info(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

abstract class Officer{
    protected Officer next;
    public void setNext(Officer officer){
        this.next = officer;
    }
    public abstract boolean handle(Info info);
}

class Squad extends Officer{
    public boolean handle(Info info){
        if(info.getNumber() < 10){
            System.out.println("作战命令已由班长下达！");
            return true;
        }else if(next != null){
            return next.handle(info);
        }else {
            return false;
        }
    }
}

class Platoon extends Officer{
    public boolean handle(Info info){
        if(info.getNumber() >= 10 && info.getNumber() < 50){
            System.out.println("作战命令已由排长下达！");
        }else if(next != null){
            return next.handle(info);
        }else {
            return false;
        }
        return false;
    }
}

class Battalion extends Officer{
    public boolean handle(Info info){
        if(info.getNumber() >= 50 && info.getNumber() < 200){
            System.out.println("作战命令已由营长下达！");
        }else if(next != null){
            return next.handle(info);
        }else {
            System.out.println("敌人数量过多,需要开会讨论再下达作战命令。");
            return false;
        }
        return false;
    }
}
//          1）敌人数量<10,班长下达作战命令。
//        （2）10<=敌人数量<50,排长下达作战命令。
//        （3）50<=敌人数量<200，营长下达作战命令。
//        （4）敌人数量>=200,需要开会讨论再下达作战命令。
//
public class Client {
    public static void main(String[] args) {
        Officer squad = new Squad();
        Officer platoon = new Platoon();
        Officer battalion = new Battalion();

        squad.setNext(platoon);
        platoon.setNext(battalion);
        squad.handle(new Info(3));
        squad.handle(new Info(30));
        squad.handle(new Info(60));
        squad.handle(new Info(600));
    }

}
