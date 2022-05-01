import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * @Auther: Administrator
 * @Date: 2019-04-23 08:55
 * @Description:
 */
public class Test {
    public static void main(String[] args) throws IOException {
        AtomicInteger atomicInteger = new AtomicInteger(8);
        int andUpdate = atomicInteger.getAndUpdate(p -> p/2);
        System.out.println(andUpdate);
        System.out.println(atomicInteger.get());

    }

    public void method1(int i){
        i++;
    }

    public static void writeFile() throws IOException {
        byte[] bytes = new byte[1024*1024]; //1024*1024 = 1M
        byte ch = 1;
        for(byte c:bytes){
            c = ch;
        }
        File file = new File(System.getProperty("user.dir") + "/src/test/java/test.txt");
        if(!file.exists())
            file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.close();
    }
}
