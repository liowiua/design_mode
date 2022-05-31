package facade;
class FileOperation {
    public String read(String fileName) {return null;}  //读取文件代码省略
}

class XMLDataConvertor {
    public String convert(String fileStr) {return null; } //文件格式转换代码省略
}

class DataAnalysis {
    public String handle(String xmlStr) {return null; } //数据分析统计代码省略
}

class ReportDisplay
{
    public void display(String xmlStr) {  }//报表显示代码省略
}

abstract class AbstractFacade  //(1)
{
    public abstract void execute(String fileName);
}

class XMLFacade extends AbstractFacade
{
    private FileOperation fo;
    private DataAnalysis da;
    private ReportDisplay rd;

    public XMLFacade()
    {
        fo = new FileOperation();
        da = new DataAnalysis();
        rd = new ReportDisplay();
    }

    public void execute(String fileName)
    {
        String str = fo.read(fileName); //读取文件(2)
        String strResult = da.handle(str); //分析数据(3)
        rd.display(strResult); //显示报表(4)
    }
}

class ExtendedFacade extends AbstractFacade
{
    private FileOperation fo;
    private XMLDataConvertor dc;
    private DataAnalysis da;
    private ReportDisplay rd;

    public ExtendedFacade()
    {
        fo = new FileOperation();
        dc = new XMLDataConvertor();
        da = new DataAnalysis();
        rd = new ReportDisplay();
    }

    public void execute(String fileName)
    {
        String str = fo.read(fileName); //读取文件(5)
        String strXml = dc.convert(str); //转换文件(6)
        String strResult = da.handle(strXml); //分析数据(7)
        rd.display(strResult); //显示报表(8)
    }
}

class Test
{
    public static void main(String args[])
    {
        AbstractFacade facade;
        facade = new XMLFacade();  //        (9)
        facade.execute("file.xml");
    }
}
