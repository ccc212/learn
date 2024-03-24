import org.example.FolderUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FolderTest {
    @Test
    public void test1() throws IOException {
        FolderUtils.copyFolder(new File("./src/main/java/org/example/testFolder/testTxt1.txt"), new File("./temp"));
    }

    @Test
    public void test2() throws IOException {
        FolderUtils.copyFolder(new File("./src/main/java/org/example/testFolder"), new File("./temp"));
    }

    @Test
    public void test3() {
        String filePath = "./src/main/java/org/example/testFolder/testTxt1.txt";
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            System.out.println("找到指定文件: " + file.getAbsolutePath());
        } else {
            System.out.println("文件不存在或不是一个文件。");
        }
    }

    @Test
    public void test4() {
        System.out.println("当前工作目录：" + System.getProperty("user.dir"));
    }

    @Test
    public void test5() {
        File file = new File("./temp");
        if (!FolderUtils.isFolderEmpty(file)) {
            FolderUtils.deleteFolder(file);
        }
    }
}
