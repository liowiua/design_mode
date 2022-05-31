package test1;

abstract class ImageReader{
	public abstract void read();
}

class GifReader extends ImageReader {
	public void read(){
		System.out.println("reading gif");
	}
}

class JpgReader extends ImageReader {
	public void read(){
		System.out.println("reading jpg");
	}
}

abstract class Factory{
	public abstract ImageReader FactoryMethod();
} 

class GifReaderFactory extends Factory{
	@Override
	public ImageReader FactoryMethod(){
		return new GifReader();
	} 	
}

class JpgReaderFactory extends Factory{
	@Override
	public ImageReader FactoryMethod(){
		return new JpgReader();
	} 	
}

public class FactoryMethod{
	public static void main(String[] args) {
		Factory factory = new GifReaderFactory();
		ImageReader imageReader = factory.FactoryMethod();
		imageReader.read();
	}
}