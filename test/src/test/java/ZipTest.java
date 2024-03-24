import org.example.ZipUtil;
import org.junit.jupiter.api.Test;

import java.io.File;

public class ZipTest {
    @Test
    public void test1() {
        File file = new File("./world.zip");
        ZipUtil.Zip(new File("./src/main/java/org/example/testFolder"),file);
    }

    @Test
    public void test2() {
        ZipUtil.UnZip(new File("./world.zip"),new File("./unzip"));
    }


}
