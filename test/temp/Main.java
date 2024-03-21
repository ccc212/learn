package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File temp = new File("./temp");
        temp.mkdir();
        FolderUtils.copyFolder(new File("./"),temp);
    }
}
