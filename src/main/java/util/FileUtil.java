package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static String[] getDataFromFile(String fileName) throws IOException {
        List<String> list = new ArrayList();
        ClassLoader classLoader = FileUtil.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            list.add(st);
        }
        return list.toArray(new String[list.size()]);
    }
}
