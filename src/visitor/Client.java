package visitor;

import java.util.ArrayList;
import java.util.List;

abstract class ItemHandler
{
    public abstract void handle(Book item);
    public abstract void handle(Magazine item);
    public abstract void handle(Paper item);
}

class PageHandler extends ItemHandler
{
    public void handle(Book item)
    {  //图书页数处理
        System.out.println("图书：《" + item.bookName +  "》页数：" + item.totalPages);
    }
    public void handle(Magazine item)
    {  //期刊页数处理
        int pages = 0;
        for(Object obj : item.papers)
        {
            pages += ((Paper)obj).pages ;  //计算期刊总页数          !!!!!!!!!!!!!!!!!!
        }
        System.out.println("杂志：《" + item.magazineName + item.magazineNo +  "》页数：" + pages);
        System.out.println("包含论文如下：");
        for(Object obj : item.papers)
        {
            System.out.println("论文：《" + ((Paper)obj).paperTitle +  "》页数：" + ((Paper)obj).pages);
        }
    }
    public void handle(Paper item)
    {  //论文页数处理
        System.out.println("论文：《" + item.paperTitle +  "\"》页数：" + item.pages);
    }
}

class AuthorHandler extends ItemHandler
{
    public void handle(Book item)
    {  //图书作者处理，代码省略
    }
    public void handle(Magazine item)
    {  //期刊作者处理，代码省略
    }
    public void handle(Paper item)
    {  //论文页数处理，代码省略
    }
}

interface Item
{
    public void accept(ItemHandler handler);
}

class Magazine implements Item
{
    public List<Paper> papers = new ArrayList();
    public String magazineName;
    public String magazineNo;
    public void addPaper(Paper paper)
    {
        papers.add(paper);     //      !!!!!!!!!!!
    }
    public void accept(ItemHandler handler)
    {
        handler.handle(this);    //!!!!!!!!!!!!!!!!
    }
}

class Book implements Item
{
    public String bookName;
    public String author;
    public int totalPages;
    public void accept(ItemHandler handler)
    {
        handler.handle(this);           //!!!!!!!!!!!!!!!!
    }
}

class Paper implements Item
{
    public String paperTitle;
    public String author;
    public int pages;
    public void accept(ItemHandler handler)
    {
        handler.handle(this);           //!!!!!!!!!!!!!!!!
    }
}

class Libaray
{
    private List items = new ArrayList();
    public void addItem(Item item)
    {
        items.add(item);              //!!!!!!!!!!!!!!!!
    }
    public void accept(ItemHandler handler)
    {
        for(Object obj : items)
        {
            ((Item)obj).accept(handler);
             //!!!!!!!!!!!!!!!!
//            if(obj.getClass().getSimpleName().compareTo("Book") == 0)
//                handler.handle((Book) obj);//
//            else if(obj.getClass().getSimpleName().compareTo("Magazine") == 0)
//                handler.handle((Magazine) obj);//
//            else if((obj.getClass().getSimpleName().compareTo("Paper") == 0))
//                handler.handle((Paper) obj);//

        }
    }
}

public class Client
{
    public static void main(String args[])
    {
        Book book = new Book();
        book.bookName = "21天精通九阳神功";
        book.author = "张无忌";
        book.totalPages = 450;
        Magazine magazine = new Magazine();
        magazine.magazineName = "功夫学报";
        magazine.magazineNo = "2011年第1期";
        Paper paper1 = new Paper();
        paper1.paperTitle = "如何单手制服敌人";
        paper1.author = "杨过";
        paper1.pages = 12;
        Paper paper2 = new Paper();
        paper2.paperTitle = "我和杨过的功夫情缘";
        paper2.author = "小龙女";
        paper2.pages = 8;
        Paper paper3 = new Paper();
        paper3.paperTitle = "研究报告-靖哥哥的九大弱点";
        paper3.author = "黄蓉";
        paper3.pages = 30;
        magazine.addPaper(paper1);
        magazine.addPaper(paper2);

        Libaray lib = new Libaray();
        lib.addItem(book);
        lib.addItem(magazine);
        lib.addItem(paper3);
        ItemHandler handler = new PageHandler();
        lib.accept(handler);   //访问对象结构

    }
}
