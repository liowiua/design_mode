package birdge;

public class HeiMaClient {
    public static void main(String[] args) {
        OperatingSystem system = new Mac(new AviFile());
        system.play("泰坦尼克号");
    }
}
interface VideoFile {
    void decode(String fileName);
}
class AviFile implements VideoFile {
    @Override
    public void decode(String fileName) {
        System.out.println("Avi视屏文件："+fileName);
    }
}
class RmvbFile implements VideoFile {
    @Override
    public void decode(String fileName) {
        System.out.println("Rmvb视屏文件："+fileName);
    }
}
abstract class OperatingSystem {
    protected VideoFile videoFile;
    public OperatingSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }
    abstract void play(String fileName);
}
class Windows extends OperatingSystem {
    public Windows(VideoFile videoFile) {
        super(videoFile);
    }
    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
class Mac extends OperatingSystem {
    public Mac(VideoFile videoFile) {
        super(videoFile);
    }
    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}